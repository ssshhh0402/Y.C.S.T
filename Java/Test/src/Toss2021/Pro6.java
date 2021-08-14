package Toss2021;

public class Pro6 {
    public static long solution(int numOfStairs){
        int [] dp = new int[numOfStairs+1];
        for(int i = 1; i < numOfStairs+1; i++){
            if(i == 1){
                dp[i] = 1;
            }else if(i == 2){
                dp[i] = dp[i-1] + 1;
            }else if(i == 3){
                dp[i] = dp[i-1] + dp[i-2] + 1;
            }else{
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        return dp[numOfStairs];
    }
    public static void main(String[] args){
        int numOfStairs = 1;
        System.out.println(solution(numOfStairs));
    }
}
