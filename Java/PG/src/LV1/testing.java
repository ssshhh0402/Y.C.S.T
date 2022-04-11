package LV1;

public class testing {
    public static int solution(int [] arr){
        int minValue = Integer.MIN_VALUE;
        int min = -1;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            count += arr[i];
            if(arr[i] * arr[i] > minValue){
                minValue = arr[i] * arr[i];
                min = arr[i];
            }
        }
        int [][] dp = new int[arr.length][2];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0] * arr[0];
        for(int i = 1; i < arr.length; i++){
            dp[i][0] = dp[i-1][0] + arr[i];
            dp[i][1] = Math.max(dp[i-1][0]+(arr[i]*arr[i]), dp[i-1][1] + arr[i]);
        }

        return count - min + (min * min);
    }
    public static void main(String[] args){
        int [] arr = new int[]{-3,2,1,0};
        System.out.println(solution(arr));
    }
}
