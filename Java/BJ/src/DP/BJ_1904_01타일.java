package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1904_01타일 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N+1];

        for(int i = 1; i < N+1; i++){
            if(i < 3){
                dp[i] = i % 15746;
            }else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
            }
        }
        System.out.println(dp[N] % 15746);
    }
}
