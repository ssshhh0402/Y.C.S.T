import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpUtil {
    String base_url, token;
    String x_auth_token = "5391f07cd2b27c88e1fcc548741942ef";
    JSONParser parser = new JSONParser();
    long time;
    public String testing(String sendUrl, String type) throws IllegalStateException, IOException {
        URL url = new URL(this.base_url + sendUrl);
        StringBuilder sb = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(type);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        int status = con.getResponseCode();
        while((inputLine = in.readLine()) != null){
            sb.append(inputLine);
        }
        in.close();
        con.disconnect();
        return sb.toString();
    }
//    public String login(String sendurl, String type){
//        try{
//            URL url = new URL(this.base_url + sendurl);
//            StringBuilder sb = new StringBuilder();
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod(type);
//            con.setRequestProperty("Content-Type", "application/json");
//            con.setDoOutput(true);
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
//            JSONObject job = new JSONObject();
//            job.put("email", "ssshhh0402@naver.com");
//            job.put("password", "tnsqja4856");
//            bw.write(job.toString());
//            bw.flush();
//            bw.close();
//            if(con.getResponseCode() == 200){
//                BufferedReader result = new BufferedReader(new InputStreamReader(con.getInputStream()));
//                String input;
//                while((input = result.readLine()) != null){
//                    sb.append(input);
//                }
//                result.close();
//                con.disconnect();
//            }
//            return sb.toString();
//        }catch(Exception e){
//            System.out.println(e.toString());
//            return "????";
//        }
//    }
    public void Score(){
        try{
            URL url = new URL(this.base_url + "/score");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "applicatino/json");
            con.setRequestProperty("Authorization", this.token);
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String inline;
            while((inline = br.readLine()) != null){
                sb.append(inline);
            }
            br.close();
            con.disconnect();
            JSONObject jo = (JSONObject)parser.parse(sb.toString());
            Double score = (Double)jo.get("score");
            System.out.println(score);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public void Moving(){
        try{
            URL url = new URL(this.base_url + "/simulate");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Authorization", this.token);
            con.setRequestProperty("Content-Type", "applicatino/json");
            con.setDoOutput(true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
            JSONArray ja = new JSONArray();
            JSONObject jo = new JSONObject();
            JSONObject jo2 = new JSONObject();
            int [] data = new int [] {2,5,4,1,6};
            jo2.put("truck_id", 0);
            jo2.put("command", data);
            ja.add(jo2);
//            data = new int[] {0};
//            jo2 = new JSONObject();
//            jo2.put("truck_id", 1);
//            jo2.put("command", data);
//            ja.add(jo2.toString());
//            jo2 = new JSONObject();
//            jo2.put("truck_id", 2);
//            jo2.put("command", data);
//            ja.add(jo2.toString());
//            jo2 = new JSONObject();
//            jo2.put("truck_id", 3);
//            jo2.put("command", data);
//            ja.add(jo2.toString());
//            jo2 = new JSONObject();
//            jo2.put("truck_id", 4);
//            jo2.put("command", data);
//            ja.add(jo2.toString());
            jo.put("commands", ja);
            bw.write(jo.toString());
            bw.flush();
            bw.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String input;
                while ((input = br.readLine()) != null) {
                    sb.append(input);
                }
                br.close();
                con.disconnect();

                JSONObject jo3 = (JSONObject) parser.parse(sb.toString());
                System.out.println("------");
                System.out.println("status : " + jo3.get("status"));
                System.out.println("time : " + jo3.get("time"));
                System.out.println("failed : " + jo3.get("failed_requests_count"));
                System.out.println("distance : " + jo3.get("distance"));
                System.out.println("------");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
    public long [][] location(){
        long [][] base;
        try{
            URL url = new URL(this.base_url + "/locations");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "applicatino/json");
            con.setRequestProperty("Authorization", this.token);
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String inline;
            while((inline = br.readLine()) != null){
                sb.append(inline);
            }
            br.close();
            con.disconnect();
            JSONObject jo = (JSONObject) parser.parse(sb.toString());
            JSONArray ja = (JSONArray)jo.get("locations");
            int n = (int)Math.sqrt(ja.size());
            base = new long[n][n];
            for(int i = 0 ; i < ja.size(); i++){
                JSONObject now = (JSONObject)ja.get(i);
                long id = (long)now.get("id");
                long bikes = (long)now.get("located_bikes_count");
                int x = (int)(n - (id % n)-1);
                int y = (int) (id / n);
                base[x][y] = bikes;
            }
            return base;
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
    public ArrayList<Truck> getTrucks(int n){
        ArrayList<Truck> al = new ArrayList<Truck>();
        try{
            URL url = new URL(this.base_url + "/trucks");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "applicatino/json");
            con.setRequestProperty("Authorization", this.token);
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String inline;
            while((inline = br.readLine()) != null){
                sb.append(inline);
            }
            br.close();
            con.disconnect();
            JSONObject jo = (JSONObject)parser.parse(sb.toString());
            JSONArray ja = (JSONArray)jo.get("trucks");
            for(Object item : ja){
                JSONObject target = (JSONObject)item;
                long id = (long)target.get("id");
                int x = (int)(n - (id % n)-1);
                int y = (int) (id / n);
                long count = (long)(target.get("loaded_bikes_count"));
                al.add(new Truck(x,y,id,count));
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return al;
    }
    public void start(){
        try {
            URL url = new URL(this.base_url + "/start");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("X-Auth-Token", this.x_auth_token);
            con.setDoOutput(true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
            JSONObject job = new JSONObject();
            job.put("problem", 1);
            bw.write(job.toString());
            bw.flush();
            bw.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String inline;
            while((inline = br.readLine()) != null){
                sb.append(inline);
            }
            br.close();
            con.disconnect();
            JSONObject jo = (JSONObject)parser.parse(sb.toString());
            this.token = (String)jo.get("auth_key");
            this.time = (long)jo.get("time");
            System.out.println(sb.toString());
            System.out.println(this.token);
            System.out.println(this.time);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public ArrayList<Post> JsonToString(String target){
        ArrayList<Post> posts = new ArrayList<Post>();
        JSONParser parser=  new JSONParser();
        try {
            JSONArray ja = (JSONArray) (parser.parse(target));
            int n = ja.size();
            for(int i = 0 ; i < n; i++){
                JSONObject jo = (JSONObject)ja.get(i);
                posts.add(new Post(jo));
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return posts;
    }
    public ArrayList<Post> getPosts(String target_url, String type){
        JSONParser parser = new JSONParser();
        ArrayList<Post> al = new ArrayList<Post>();
        try{
            URL url = new URL("https://jsonplaceholder.typicode.com" + target_url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(type);
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder result = new StringBuilder();
            String inputLine;
            while((inputLine = br.readLine()) != null){
                result.append(inputLine);
            }
            JSONArray ja = (JSONArray)parser.parse(result.toString());
            int n = ja.size();
            for(int i = 0 ; i < n; i++){
                JSONObject jo = (JSONObject)ja.get(i);
                al.add(new Post(jo));
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return al;
    }
    public void test(){
//        try{
//            URL url = new URL(this.base_url + "/get");
//            HttpURLConnection con = (HttpURLConnection)url.openConnection();
//            con.setRequestMethod("GET");
//            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            StringBuilder result = new StringBuilder();
//            String inputLine;
//            while((inputLine = br.readLine()) != null){
//                result.append(inputLine);
//            }
//            System.out.println(result.toString());
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }
//        try{
//            URL url = new URL(this.base_url + "/put");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod(("PUT"));
//            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            StringBuilder result = new StringBuilder();
//            String inputLine;
//            while((inputLine = br.readLine()) != null){
//                result.append(inputLine);
//            }
//            System.out.println(result.toString());
//        }catch(Exception e){
//            System.out.println(e.toString());
//        }
        try{
            URL url = new URL(this.base_url + "/basic-auth/ssshhh0402/0402");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder result = new StringBuilder();
            String input;
            while((input = br.readLine()) != null){
                result.append(input);
            }
            System.out.println(result.toString());
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public ArrayList<User> getUsers(String target_url, String type){
        JSONParser parser = new JSONParser();
        ArrayList<User> al = new ArrayList<User>();
        try{
            URL url = new URL(this.base_url + target_url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(type);
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            JSONArray ja = (JSONArray)parser.parse(sb.toString());
            int n = ja.size();
            for(int i = 0 ; i < n; i++){
                al.add(new User((JSONObject)ja.get(i)));
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return al;
    }
    public HttpUtil(String a){
        this.base_url = a;
    }
}

