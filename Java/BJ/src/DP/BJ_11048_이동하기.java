package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11048_이동하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        int[][] dp = new int[N][M];
        int [][] base = new int[N][M];
        for(int x = 0; x < N; x++){
            inputs = br.readLine().split(" ");
            for(int y = 0; y < M; y++){
                base[x][y] = Integer.parseInt(inputs[y]);
            }
        }
        for(int x = 0 ; x < N; x++){
            for(int y = 0 ; y < M; y++){
                if(x == 0 && y == 0){
                    dp[x][y] = base[x][y];
                }else if(x == 0){
                    dp[x][y] = dp[x][y-1] + base[x][y];
                }else if(y == 0){
                    dp[x][y] = dp[x-1][y] + base[x][y];
                }else{
                    dp[x][y] = Math.max(dp[x-1][y],Math.max(dp[x-1][y-1],dp[x][y-1])) + base[x][y];
                }
            }
        }
        System.out.println(dp[N-1][M-1]);
    }
}
