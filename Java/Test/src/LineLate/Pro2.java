package LineLate;

import java.util.*;

public class Pro2 {
    static HashMap<Integer, ArrayList<String>> months;
    static Map<String, Integer> answer;
    static HashMap<String ,boolean[]> hm;
    public static boolean isSafe(String key, int start, int end, int N){
        for(int i = start; i < N; i++){
//            for(int j = i - end; j < i; j++){
////                if(mon)
//            }
        }
        return true;
    }
    public static String solution(String [] research, int n, int k){
        int N = research.length;
        answer = new LinkedHashMap<String, Integer>();
        months = new HashMap<Integer, ArrayList<String>>();
        hm = new HashMap<String, boolean []>();
        for(int i = 0; i < N; i++){
            String [] data = research[i].split("");
            HashMap<String, Integer> today = new HashMap<String, Integer>();
            for(int j = 0 ; j < data.length; j++){
                if(today.containsKey(data[j])){
                    today.replace(data[j], today.get(data[j]) + 1);
                }else{
                    today.put(data[j], 1);
                }
            }
            for(String key : today.keySet()){
                if(today.get(key) >= n) {
                    ArrayList<String> temps = months.get(i);
                    if (!temps.contains(key)) {
                        temps.add(key);
                        months.replace(i, temps);
                    }
                }
            }
        }
        for(int i = k; i < N; i++){
            ArrayList<String> names = new ArrayList<String>();
            for(String key : hm.keySet()){
//                if(isSafe(key) && !names.contains(key)){
//                    names.add(key);
//                }
                System.out.println(key);
            }
            Collections.sort(names);
            String temps = names.get(0);
            if(answer.containsKey(temps)){
                answer.replace(temps, answer.get(temps)+1);
            }else{
                answer.put(temps, 1);
            }
        }
        int result = 0;
        String result_return = "";
        if(answer.size() == 0){
            return "None";
        }
        for(String key : answer.keySet()){
            if(answer.get(key) > result){
                result = answer.get(key);
                result_return = key;
            }else if(answer.get(key) == result){
                if(key.compareTo(result_return) > 0){
                    result_return = key;
                }
            }
        }
        return result_return;
    }
    public static void main(String[] args){
        String [] research = {"abaaaa","aaa","abaaaaaa","fzfffffffa"};
        int n = 2;
        int k= 2;
        System.out.println(solution(research, n, k));
        research = new String [] {"yxxy","xxyyy"};
        n = 2;
        k = 1;
        System.out.println(solution(research, n, k));
    }
}
