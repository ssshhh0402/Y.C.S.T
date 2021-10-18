package Devmat_Back_Late;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pro1 {
    public static boolean isContains(String target, String [] registered_list){
        for(String item : registered_list){
            if (target.equals(item)) {
                return true;
            }
        }
        return false;
    }
    public static int getIdx(String new_id){
        int answer = 0;
        for(int i = 0; i < new_id.length(); i++){
            if (Character.isDigit(new_id.charAt(i))) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    public static String newOne(String new_id){
        int idx = getIdx(new_id);
        String result = "";
        if(idx == 0){
            result = new_id + String.valueOf(1);
        }else{
            result = new_id.substring(0,idx) + String.valueOf(Integer.parseInt(new_id.substring(idx))+1);
        }
        return result;
    }
    public static String solution(String [] registered_list, String new_id){
        Map<String, ArrayList<Integer>> m = new LinkedHashMap<String, ArrayList<Integer>>();
        for(String item : registered_list){
            int idx = getIdx(item);
            String now_N;
            int now_S;
            if(idx == 0){
                now_N = item;
                now_S = 0;
            }else {
                now_N = item.substring(0, idx);
                now_S = Integer.parseInt(item.substring(idx));
            }
            if(m.containsKey(now_N)){
                ArrayList<Integer> al = m.get(now_N);
                al.add(now_S);
                m.replace(now_N, al);
            }else{
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(now_S);
                m.put(now_N, al);
            }

        }
        String N;
        int S;
        int idx = getIdx(new_id);
        if(idx == 0){
            N = new_id;
            S = 0;
        }else{
            N = new_id.substring(0, idx);
            S = Integer.parseInt(new_id.substring(idx));
        }
        if(m.containsKey(N)){
            ArrayList<Integer> al = m.get(N);
            while(al.contains(S)){
                    S+=1;
                }
        }
        String answer;
        if(S == 0){
            answer = N;
        }else{
            answer = N + String.valueOf(S);
        }
        return answer;
    }
    public static void main(String[] args){
        String [] registered_list = new String [] {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
        String new_id = "ace15";
//        System.out.println(solution(registered_list, new_id));
        registered_list = new String [] {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
        new_id = "cow";
        System.out.println(solution(registered_list, new_id));
        registered_list = new String [] {"bird99", "bird98", "bird101", "gotoxy"};
        new_id = "bird98";
        System.out.println(solution(registered_list, new_id));
    }
}
