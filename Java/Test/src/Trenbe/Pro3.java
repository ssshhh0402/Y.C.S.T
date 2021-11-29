package Trenbe;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pro3 {
    public static int solution(int [] arr){
        Map<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            int now = arr[i];
            if(m.containsKey(now)){
                answer = Math.min(answer,i - m.get(now));
                m.replace(now, i);
                break;
            }else{
                m.put(now, i);
            }
        }
        if(answer == Integer.MAX_VALUE){
            return -1;
        }else {
            return answer;
        }
    }
    public static void main(String[] args){
        int [] arr = new int [] {2, 1, 3, 1, 4, 2, 1, 3};
        System.out.println(solution(arr));

    }
}
