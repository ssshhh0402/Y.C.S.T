package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9251_LCS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] one = br.readLine().split("");
        String [] two = br.readLine().split("");
        int N = one.length, M = two.length;
        int [][] dp = new int[N+1][M+1];
        for(int x = 1; x < N+1; x++){
            for(int y= 1; y < M+1; y++){
                if(one[x-1].equals(two[y-1])){
                    dp[x][y] = dp[x-1][y-1] + 1;
                }else{
                    dp[x][y] = Math.max(dp[x-1][y],dp[x][y-1]);
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
