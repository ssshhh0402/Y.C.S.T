import java.util.ArrayList;
import java.util.Collections;

public class Review {

    public static int solution(int m, int n, int [][] puddles){
        int [][] dp = new int[n][m];

        for(int [] puddle : puddles){
            dp[puddle[0]-1][puddle[1]-1] = -1;
        }
        for(int x = 0; x < n; x++){
            if(dp[x][0] == -1){
                break;
            }else {
                dp[x][0] = 1;
            }
        }
        for(int y = 0; y < m; y++){
            if(dp[0][y] == -1){
                break;
            }else {
                dp[0][y] = 1;
            }
        }
        for(int x = 1; x < n; x++){
            for(int y = 1; y < m; y++){
                if(dp[x][y] == -1){
                    continue;
                }
                if(dp[x-1][y] >= 0 && dp[x][y-1] >= 0){
                    dp[x][y] = dp[x-1][y] + dp[x][y-1];
                }else{
                    if(dp[x-1][y] == -1 && dp[x][y-1] == -1){
                        continue;
                    }else if(dp[x-1][y] == -1){
                        dp[x][y] = dp[x][y-1];
                    }else{
                        dp[x][y] = dp[x-1][y];
                    }
                }
            }
        }
        return (dp[n-1][m-1] % 1000000007);
    }
    public static void main(String[] args){
        int m = 4;
        int n = 3;
        int [][] puddles = new int [][] {{2,2}};
        System.out.println(solution(m,n,puddles));
    }
}
