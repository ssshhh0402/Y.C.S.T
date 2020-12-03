package 이분탐색;

import java.util.Arrays;

public class 징검다리 {

    public static int solution(int distance, int[] rocks, int n){
        int answer = 0;
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        int mid = 0;
        while(left <= right){
            int last = 0;
            int count = 0;
            mid = (left + right) / 2;
            for(int rock : rocks){
                if(mid > rock - last){
                    count += 1;
                }else{
                    last = rock;
                }
            }
            if (count > n){
                right = mid - 1;
            }else{
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(25, new int [] {2,14,11,21,17},2));
    }
}
