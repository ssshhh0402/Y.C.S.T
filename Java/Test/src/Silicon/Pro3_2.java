package Silicon;

import java.util.ArrayList;

public class Pro3_2 {
    public static long[] rotate(long [] target){
        int n = target.length;
        long [] result = new long[n];
        for(int i = 0; i < n; i++){
            result[(i+1)%n]=target[i];
        }
        return result;
    }
    public static long getSum(long [] wave1, long [] wave2){
        int n = wave1.length, m = wave2.length;
        long result = 0;
        if(n > m){
            for(int i = 0 ; i < n; i++){
                result += Math.pow(wave1[i]+wave2[i%m],2);
            }
        }else{
            for(int i = 0; i < m; i++){
                result += Math.pow(wave1[i%n] + wave2[i],2);
            }
        }
        return result;
    }
    public static long solution(long [] wave1, long[] wave2){
        int count = 0;
        long answer = Integer.MAX_VALUE;
        while(count < wave2.length){
            long result = getSum(wave1, wave2);
            answer = Math.min(answer, result);
            wave2 = rotate(wave2);
            count+=1;
        }
        return answer;
    }
    public static void main(String[] args){
        long [] wave1 = new long [] {1, 2, 2, 1, 1, 2};
        long [] wave2 = new long [] {-2, -1};
//        System.out.println(solution(wave1,wave2));
        wave1 = new long [] {0, 1, 1, 1, 1, 1};
        wave2 = new long [] {0, 0, 1, 0, 0, 0};
        System.out.println(solution(wave1, wave2)); // 0
        wave1 = new long [] {2, 0, 1, 1, 1, 0};
        wave2 = new long [] {0, 0, -1};
        System.out.println(solution(wave1, wave2)); // 1;
    }
}
