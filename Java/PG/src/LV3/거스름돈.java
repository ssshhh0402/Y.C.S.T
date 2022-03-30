package LV3;

public class 거스름돈 {
    public static int solution(int n, int [] money){
        int m = money.length;
        int [][] dp = new int[m+1][n+1];
        for(int x = 1; x < m+1; x++){
            for(int y = 0; y < n+1; y++){
                if(y < money[x-1]){
                    dp[x][y] = dp[x-1][y] % 1000000007;
                }else if(y == money[x-1]){
                    dp[x][y] = (dp[x-1][y]+1) % 1000000007;
                }else{
                    dp[x][y] = (dp[x-1][y] + dp[x][y-money[x-1]]) % 1000000007;
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args){
        int n = 5;
        int [] money = new int [] {1,2,5};
        System.out.println(solution(n,money));
    }
}
