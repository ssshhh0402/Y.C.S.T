package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11052_카드구매 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] base = new int[N+1];
        String[] inputs = br.readLine().split(" ");
        for(int i = 1 ; i < N+1; i++){
            base[i] = Integer.parseInt(inputs[i-1]);
        }
        int [] dp = new int[N+1];
        for(int i = 1;i < N+1; i++){
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + base[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
