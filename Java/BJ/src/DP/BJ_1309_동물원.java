package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1309_동물원 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] dp = new int[N][3];
        for(int y = 0; y < 3; y++){
            dp[0][y] = 1;
        }
        for(int x = 1; x < N; x++){
            dp[x][0] = (dp[x-1][0] + dp[x-1][1] + dp[x-1][2]) % 9901;
            dp[x][1] = (dp[x-1][0] + dp[x-1][2]) % 9901;
            dp[x][2] = (dp[x-1][0] + dp[x-1][1]) % 9901;
        }
        long answer = 0;
        for(int y = 0; y < 3; y++){
            answer += dp[N-1][y];
        }
        System.out.print(answer % 9901);
    }
}
