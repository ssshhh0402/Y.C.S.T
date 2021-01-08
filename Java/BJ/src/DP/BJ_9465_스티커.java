package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9465_스티커 {
    static int n;
    static int [][] base;
    static int [][] dp;
    static String [] inputs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        while(T > 0){
            T -= 1;
            n = Integer.parseInt(br.readLine());
            base = new int[2][n+1];
            dp = new int[2][n+1];
            for(int x = 0 ; x < 2; x++){
                inputs = br.readLine().split(" ");
                for(int y = 1 ; y < n+1; y++){
                    base[x][y] = Integer.parseInt(inputs[y-1]);
                }
            }
            dp[0][1]= base[0][1];
            dp[1][1] = base[1][1];
            for(int i = 2; i < n+1; i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + base[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + base[1][i];
            }
            sb.append(Math.max(dp[0][n],dp[1][n]) + "\n");
        }
        System.out.println(sb.toString());
    }
}
