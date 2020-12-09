package 이분탐색;

import java.util.Arrays;

public class 입국심사 {
    public static long solution(int n, int[] times){
        long answer = 0;
        Arrays.sort(times);
        long [] base = new long[times.length];
        for(int i= 0 ; i < times.length; i++){
            base[i] = Long.valueOf(times[i]);
        }
        long start = 1;
        long end = n * times[times.length - 1];
        long mid = 0;
        answer = end;
        while (start <= end){
            long count = 0;
            mid = (start + end) / 2;
            for(long time : base){
                count += mid / time;
            }
            if(count < n){
                start = mid + 1;
            }else{
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(6, new int [] {7,10}));
    }
}
