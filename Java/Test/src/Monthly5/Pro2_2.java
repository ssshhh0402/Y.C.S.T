package Monthly5;

import java.util.Collections;

public class Pro2_2 {
    public static long find(long item){
        long answer = 0;
        String target = new StringBuffer(Long.toBinaryString(item)).reverse().toString();
        int n = target.length();
        if(target.contains("0")){
            int idx = target.indexOf('0');
            boolean flag = false;
            for(int i = idx-1; i >= 0; i--){
                if(target.charAt(i) == '1')
                    if(!flag){
                        flag = true;
                    }else{
                     answer += Math.pow(2, i);
                    }
            }
            answer += Math.pow(2, idx);
            for(int i = idx+1; i < n; i++){
                answer += target.charAt(i) * Math.pow(2, i);
            }
        }else{
            answer += Math.pow(2, n);
            boolean flag = false;
            for(int i = 0; i < n; i++){
                if(target.charAt(n-i-1) == '1'){
                    if(!flag){
                        flag = true;
                    }else{
                        answer += Math.pow(2, n-i-1);
                    }
                }
            }
        }
        return answer;
    }
    public static long [] solution(long [] numbers){
        long [] answer = new long[numbers.length];
        for(int i = 0 ; i < numbers.length; i++){
            answer[i] = find(numbers[i]);
        }
        return answer;
    }
    public static void main(String[] args){
        long [] answers = solution(new long [] {2, 7});
        for(long answer : answers){
            System.out.println(answer);
        }
    }
}
