package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2293_동전1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int i= 0; i < n; i++){
            int target = Integer.parseInt(br.readLine());
            for(int j = 1; j < k+1; j++){
                if(j - target >= 0){
                    dp[j] += dp[j-target];
                }
            }
        }
        System.out.println(dp[k]);

    }
}
