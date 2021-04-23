package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2225_합분해 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), K = Integer.parseInt(inputs[1]);
        int [][] dp = new int [K+1][N+1];
        for(int i = 0; i < K+1; i++){
            dp[i][0] = 1;
        }
        for(int x = 1; x < K+1; x++){
            for(int y = 1; y < N+1; y++){
                dp[x][y] = (dp[x][y-1] + dp[x-1][y]) % 1000000000;
            }
        }
        System.out.print(dp[K][N]);
    }
}
