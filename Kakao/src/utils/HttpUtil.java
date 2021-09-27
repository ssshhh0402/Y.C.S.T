package utils;

import DTO.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpUtil {
    Global global;
    long problem;
    JSONParser parser = new JSONParser();
    String x_auth_token = "df6b51abb4164fee5298aec2f6e3a608", base_url = "https://huqeyhi95c.execute-api.ap-northeast-2.amazonaws.com/prod";
    String auth_key;
    public HttpUtil(long a){
        this.problem = a;
        global = new Global();
    }
    public long start(){
        try {
            URL url = new URL(this.base_url + "/start");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Auth-Token", this.x_auth_token);
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(con.getOutputStream()));
            JSONObject jo = new JSONObject();
            jo.put("problem", this.problem);
            bw.write(jo.toString());
            bw.flush();
            bw.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String input;
            while((input = br.readLine()) != null){
                sb.append(input);
            }
            br.close();
            con.disconnect();
            jo = (JSONObject)parser.parse(sb.toString());
            this.auth_key = (String)jo.get("auth_key");
            return (long)jo.get("time");
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public void waiting(long count){
        ArrayList<User> users = new ArrayList<User>();
        if(count == 0 || count > 555){
            global.setWaitings(users);
        }
        try{
            URL url = new URL(this.base_url + "/waiting_line");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", this.auth_key);
            con.setRequestProperty("Content-Type", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String input;
            while((input = br.readLine()) != null){
                sb.append(input);
            }
            JSONObject jo = (JSONObject)parser.parse(sb.toString());
            JSONArray ja = (JSONArray)(jo.get("waiting_line"));
            for(Object item : ja){
                JSONObject target = (JSONObject)item;
                users.add(new User((long)target.get("id"), (long)target.get("from")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        global.setWaitings(users);
    }
    public long Match(long n){
        ArrayList<User> al = global.getWaitings();
        JSONArray ja;
        if(n <= 555){
            ja = getFighting(al, n);
        }else{
            ja = new JSONArray();
        }
        try{
            URL url = new URL(this.base_url + "/match");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Authorization", this.auth_key);
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
            JSONObject jo = new JSONObject();
            jo.put("pairs", ja);
            bw.write(jo.toString());
            bw.flush();
            bw.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String input;
            while((input = br.readLine()) != null){
                sb.append(input);
            }
            jo = (JSONObject)parser.parse(sb.toString());
            return (long)jo.get("time");

        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    public JSONArray getFighting(ArrayList<User> al, long count){
        JSONArray result = new JSONArray();
        int n = al.size();
        Map<Long, Long> grades = global.getGrades();
        boolean [] fighted = new boolean[n];
        for(int i = 0 ; i < n; i++){
            if(!fighted[i]){
                User now = al.get(i);
                if(count - al.get(i).from > 15){
                    continue;
                }
                for(int j = 0; j < n; j++){
                    if(!fighted[j] && i != j && (count - al.get(j).from) <= 15){
                        User target = al.get(j);
                        long now_grade = (long)grades.get(now.id);
                        long target_grade = (long)grades.get(target.id);
                        if(now_grade > target_grade || now_grade == target_grade){

                            JSONArray temps = new JSONArray();
                            temps.add(now.id);
                            temps.add(target.id);
                            result.add(temps);
                            fighted[i] = true;
                            fighted[j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    public void GameResult(){
        try{
            URL url = new URL(this.base_url + "/game_result");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", this.auth_key);
            con.setRequestProperty("Content-Type", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String inline;
            while((inline = br.readLine()) != null){
                sb.append(inline);
            }
            br.close();
            con.disconnect();
            JSONObject jo = (JSONObject)parser.parse(sb.toString());
            JSONArray ja = (JSONArray)jo.get("game_result");
            Change_Grade(ja);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void Change_Grade(JSONArray ja){
        JSONArray commands = getChange(ja);
        try{
            URL url = new URL(this.base_url + "/change_grade");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Authorization", this.auth_key);
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoInput(true);
            con.setDoOutput(true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
            JSONObject jo = new JSONObject();
            jo.put("commands", commands);
            bw.write(jo.toString());
            bw.flush();
            bw.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String input;
            while((input = br.readLine()) != null){
                sb.append(input);
            }
            br.close();
            con.disconnect();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public JSONArray getChange(JSONArray ja){
        Map<Long, Long> grades = global.getGrades();
        JSONArray results = new JSONArray();
        int n = ja.size();
        for(int i = 0 ; i < n; i++){
            JSONObject now = (JSONObject)ja.get(i);
            long winner = (long)now.get("win"), loser = (long)now.get("lose");
            long winner_grade = grades.get(winner), loser_grade = grades.get(loser);
            if(winner_grade == loser_grade){
                JSONObject temps = new JSONObject();
                temps.put("id", winner);
                temps.put("grade", winner_grade + 1);
                results.add(temps);
            }else if(winner < loser){
                JSONObject temps = new JSONObject();
                temps.put("id", winner);
                temps.put("grade", loser_grade);
                results.add(temps);
                temps = new JSONObject();
                temps.put("id", loser);
                temps.put("grade", winner_grade);
            }
        }
        return results;
    }
    public JSONObject Score(){
        try {
            URL url = new URL(this.base_url+"/score");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", this.auth_key);
            con.setRequestProperty("Content-Type", "application/json");
            InputStream in = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String input;
            while((input = br.readLine()) != null){
                sb.append(input);
            }
            return (JSONObject)parser.parse(sb.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void UserInfo(){
        Map<Long, Long> users = new LinkedHashMap<Long, Long>();
        try{
            URL url = new URL(this.base_url + "/user_info");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", this.auth_key);
            con.setRequestProperty("Content-Type", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String input;
            while((input = br.readLine()) != null){
                sb.append(input);
            }
            JSONObject jo = (JSONObject)parser.parse(sb.toString());
            JSONArray ja = (JSONArray)jo.get("user_info");
            int n = ja.size();
            for(int i = 0 ; i < n; i++){
                jo = (JSONObject)ja.get(i);
                long j = (long)jo.get("id"), grade = (long)jo.get("grade");
                users.put(j, grade);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        global.setGrades(users);
    }
}
