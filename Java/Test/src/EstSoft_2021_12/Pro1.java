package EstSoft_2021_12;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pro1 {
    static Map<String, Integer> m;
    public static Map<String ,Integer> init(){
        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        result.put("A",5);
        result.put("B", 4);
        result.put("C", 3);
        result.put("D", 2);
        result.put("E", 1);
        result.put("F", 0);
        return result;
    }
    public static boolean calc(Map<String, Integer> counts){
        if(counts.containsKey("A") && counts.get("A") >= 2){
            return true;
        }else if(counts.containsKey("F") && counts.get("F") >= 2){
            return false;
        }
        int score = 0;
        int count = 0;
        int min_score = Integer.MAX_VALUE;
        int max_score = Integer.MIN_VALUE;
        for(String key : counts.keySet()){
            int now = m.get(key);
            score += (now * counts.get(key));
            if(now > max_score){
                max_score = now;
            }else if(now < min_score){
                min_score = now;
            }
            count += counts.get(key);
        }
        double result = (double)(score - min_score - max_score) / (count - 2);
        return result >= 3;
    }
    public static int solution(String [] scores){
        m = init();
        Map<String, Integer> count;
        int answer = 0;
        for(String score : scores){
            count = new LinkedHashMap<String, Integer>();
            String [] now = score.split("");
            for(String item : now){
                if(count.containsKey(item)){
                    count.replace(item, m.get(item)+1);
                }else{
                    count.put(item, 1);
                }
            }
            if(calc(count)){
                answer += 1;
            }
        }
        return answer;
    }
    public static void main(String[] args){

        String[] scores = new String[] {"AAFAFA", "FEECAA", "FABBCB", "CBEDEE", "CCCCCC"};
//        scores = new String [] {"BCD", "ABB", "FEE"};
        System.out.println(solution(scores));
    }
}
