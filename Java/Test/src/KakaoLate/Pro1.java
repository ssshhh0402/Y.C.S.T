package KakaoLate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pro1 {
    public static int [] solution(String [] id_list, String[] report, int k){
        Map<String, Integer> base = new LinkedHashMap<String, Integer>();
        Map<Integer, ArrayList<Integer>> result = new LinkedHashMap<Integer, ArrayList<Integer>>();
        String [] inputs;
        int [] answers = new int[id_list.length];

        for(int i = 0 ; i < id_list.length; i++){
            base.put(id_list[i], i);
        }
        for(String item : report){
            inputs = item.split(" ");
            int from = base.get(inputs[0]), to = base.get(inputs[1]);
            if(result.containsKey(to)){
                ArrayList<Integer> now = result.get(to);
                if(!now.contains(from)){
                    now.add(from);
                    result.replace(to, now);
                }
            }else{
                ArrayList<Integer> now = new ArrayList<Integer>();
                now.add(from);
                result.put(to, now);
            }
        }
        for(int key : result.keySet()){
            if(result.get(key).size() >= k){
                for(int from : result.get(key)){
                    answers[from] += 1;
                }
            }
        }
        return answers;
    }
    public static void main(String[] args){
        String [] id_list = {"muzi", "frodo", "apeach", "neo"};
        String [] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int [] answers = solution(id_list, report, k);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
