package LV2;

public class 등굣길 {
    public static int solution(int m, int n, int[][] puddles){
        int [][] dp = new int[n+1][m+1];
        for(int [] puddle : puddles){
            dp[puddle[0]][puddle[1]] = -1;
        }
        for(int x = 2; x < n+1; x++){
            if(dp[x][1] == -1){
                break;
            }else{
                dp[x][1] = 1;
            }
        }
        for(int y = 2; y < m+1; y++){
            if(dp[1][y] == -1){
                break;
            }else{
                dp[1][y] = 1;
            }
        }
        for(int x= 2; x < n+1; x++){
            for(int y = 2; y < m+1; y++){
                if(dp[x][y] != -1){
                    if(dp[x-1][y] >= 0 && dp[x][y-1] >= 0){
                        dp[x][y] = (dp[x][y] +dp[x-1][y] + dp[x][y-1]) % 1000000007;
                    }else{
                        if(dp[x-1][y] == -1 && dp[x][y-1] == -1){
                            continue;
                        }else if(dp[x][y-1] == -1){
                            dp[x][y] = (dp[x][y] + dp[x-1][y]) % 1000000007;
                        }else if(dp[x-1][y] == -1){
                            dp[x][y] = (dp[x][y] + dp[x][y-1]) % 1000000007;
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args){
        int m = 4;
        int n = 3;
        int [][] puddles = new int [][] {{2,2}};
        System.out.println(solution(m,n,puddles));
    }
}
