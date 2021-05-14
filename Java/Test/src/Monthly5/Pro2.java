package Monthly5;

import java.io.IOException;

public class Pro2 {
    public static boolean isPos(String one, String two){
        int n = one.length() - 1;
        int m = two.length() - 1;
        int count = 0;
        if(Math.abs(m - n) >= 3){
            return false;
        }else{
            while(n >= 0 && m >= 0){
                if(one.charAt(n) != two.charAt(m)){
                    count += 1;
                    if(count > 2){
                        return false;
                    }
                }
                n -= 1;
                m -= 1;
            }
        }
        if(one.length() == two.length()){
            return true;
        }else{
            if(count + Math.abs(one.length() - two.length()) <= 2){
                return true;
            }else{
                return false;
            }
        }
    }
    public static long find(long item){
        long answer = item + 1;
        String target = Long.toBinaryString(item);
        while(true){
            if(isPos(target, Long.toBinaryString(answer))){
                break;
            }else{
                answer += 1;
            }
        }
        return answer;
    }
    public static long [] solution(long [] numbers){
        long[] answer = new long[numbers.length];
        for(int i = 0 ; i < numbers.length; i++){
            answer[i] = find(numbers[i]);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        long [] answers = solution(new long [] {2,7});
        for(long answer : answers){
            System.out.println(answer);
        }
    }
}
