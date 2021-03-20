package GoormKote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Brandy {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs;
        inputs= br.readLine().split(" ");
        int N = Integer.parseInt(inputs[1]);
        int M = Integer.parseInt(inputs[0]);
        int [][] base = new int [N][M];
        int [][] dp = new int [N][M];
        for(int x = 0; x < N ; x ++){
            inputs = br.readLine().split(" ");
            for(int y = 0; y < M; y++){
                base[x][y] = Integer.parseInt(inputs[y]);
            }
        }
        dp[0][0] = base[0][0];
        for(int y = 1; y < M; y ++){
            dp[0][y] += dp[0][y-1] + base[0][y];
        }
        for(int x = 1; x < N; x++){
            dp[x][0] += dp[x-1][0] + base[x][0];
        }
        for(int x = 1; x < N; x++){
            for(int y = 1; y < M; y++){
                dp[x][y] = Math.max(dp[x-1][y],dp[x][y-1]) + base[x][y];
            }
        }
        System.out.println(dp[N-1][M-1]);
    }
}
