package Street11;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pro1 {
    public static int solution(String S){
        int answer = 0;
        Map<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
        int n = S.length();
        int i = 1;
        char before = S.charAt(0);
        int count = 1;
        int max_r = 0;
        while(i < n){
            char now = S.charAt(i);
            if(now != before){
                before = now;
                max_r = Math.max(count, max_r);
                if(m.containsKey(count)){
                    m.replace(count, m.get(count)+1);
                }else{
                    m.put(count, 1);
                }
                count = 1;
            }else{
                count += 1;
            }
            i+=1;
        }
        max_r = Math.max(count ,max_r);
        if(m.containsKey(count)){
            m.replace(count, m.get(count)+1);
        }else{
            m.put(count, 1);
        }
        for(int key : m.keySet()){
            System.out.println(" KEY : " + key + " VALUE : " + m.get(key));
            answer += (max_r - key)*(m.get(key));
        }
        return answer;
    }
    public static void main(String[] args){
        String S = "babaa";
//        System.out.println(solution(S));
        S = "ababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababaababababb";
//        System.out.println(S.length());
        System.out.println(solution(S));
        S = "ab";
        System.out.println(solution(S));
    }
}
