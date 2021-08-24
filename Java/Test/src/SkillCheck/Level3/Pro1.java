package SkillCheck.Level3;

public class Pro1 {
    public static int solution(int n){
        int [] dp = new int[n+1];
        for(int i = 1; i < n+1; i++){
            if(i <= 2){
                dp[i] = i;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int N = 4;
        System.out.println(solution(N));
    }
}
