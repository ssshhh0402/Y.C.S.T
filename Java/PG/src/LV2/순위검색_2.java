package LV2;

import java.util.*;

public class 순위검색_2 {
    static int answer, n;
    static Map<String, Map> infos;
    public static int getNum(ArrayList<Integer> scores, int score){
        int m = scores.size();
        Collections.sort(scores);
        int left = 0, right = scores.size()-1;
        int mid;
        while(left <= right){
            mid = (left+right) / 2;
            if(scores.get(mid) < score){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return m - left;
    }
    public static void recursive(int idx, Map<String, Map> now, String[] datas){
        if(idx == n-2){
            int num = Integer.parseInt(datas[idx+1]);
            if(datas[idx].equals("-")){
                for(String key : now.keySet()){
                    ArrayList<Integer> scores = (ArrayList)now.get(key);
                    int peopleNum = getNum(scores, num);
                    answer += peopleNum;
                }
            }else {
                if (now.containsKey(datas[idx])) {
                    ArrayList<Integer> scores = (ArrayList) now.get(datas[idx]);
                    int peopleNum = getNum(scores, Integer.parseInt(datas[idx + 1]));
                    answer += peopleNum;
                }
            }
            return;
        }
        if(datas[idx].equals("-")){
            for(String key : now.keySet()){
                recursive(idx+1, now.get(key), datas);
            }
        }else{
            if(now.containsKey(datas[idx])){
                recursive(idx+1, now.get(datas[idx]), datas);
            }
        }
    }
    public static Map<String, Map> getInfo(String [] info){
        infos = new LinkedHashMap<String, Map>();
        Map now;
        ArrayList<Integer> scores;
        for(String inf : info){
            String [] datas = inf.split(" ");
            int m = datas.length;
            if(infos.containsKey(datas[0])){
                now = infos.get(datas[0]);
            }else{
                infos.put(datas[0], new LinkedHashMap<String, Map>());
                now = infos.get(datas[0]);
            }
            for(int i = 1; i < m-1; i++){
                if(now.containsKey(datas[i])){
                    if(i == m-2){
                        scores = (ArrayList)now.get(datas[i]);
                        scores.add(Integer.parseInt(datas[i+1]));
                        now.replace(datas[i], scores);
                    }else {
                        now = (Map) now.get(datas[i]);
                    }
                }else{
                    if(i == m-2){
                        scores = new ArrayList<Integer>();
                        scores.add(Integer.parseInt(datas[i+1]));
                        now.put(datas[i], scores);
                    }else{
                        now.put(datas[i], new LinkedHashMap<String, Map>());
                        now = (Map)now.get(datas[i]);
                    }
                }
            }
        }
        return infos;
    }
    public static int [] solution(String [] info, String [] query){
        int [] answers = new int[query.length];
        Map<String, Map> infos = getInfo(info);
        for(int i = 0; i < query.length; i++){
            answer = 0;
            String q = query[i].replaceAll(" and ", " ");
            String [] datas = q.split(" ");
            n = datas.length;
            if(datas[0].equals("-")){
                for(String key : infos.keySet()){
                    recursive(1, infos.get(key), datas);
                }
            }else{
                if(infos.containsKey(datas[0])){
                    recursive(1, infos.get(datas[0]), datas);
                }
            }
            answers[i] = answer;
        }
        return answers;
    }
    public static void main(String[] args){
        String [] info = new String [] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String [] query = new String [] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int [] answers = solution(info, query);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
