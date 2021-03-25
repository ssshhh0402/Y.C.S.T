package Prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_13398_연속합2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] base = new int[N];
        int [][] dp = new int [N][2];
        String[] inputs = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        int answer = base[0];
        dp[0][0]= base[0];
        for(int i = 1; i < N; i++){
            dp[i][0] = Math.max(base[i], dp[i-1][0] + base[i]);
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + base[i]);
            answer = Math.max(answer, Math.max(dp[i][0],dp[i][1]));
        }
        System.out.println(answer);
    }
}
