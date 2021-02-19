package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11727_2타일링2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N+1];
        for(int i = 1; i < N+1; i++){
            if(i == 1){
                dp[i] = 1;
            }else if(i == 2){
                dp[i] = 3;
            }else {
                dp[i] = (2 * dp[i - 2] + dp[i - 1]) % 10007;
            }
        }
        System.out.println(dp[N] % 10007);
    }
}
