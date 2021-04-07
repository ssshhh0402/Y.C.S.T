package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_12865_평범한배낭 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), K = Integer.parseInt(inputs[1]);
        int [] Ws = new int[N+1];
        int [] Vs = new int[N+1];
        int [][] dp = new int[N+1][K+1];
        for(int i = 1; i < N+1; i++){
            inputs = br.readLine().split(" ");
            Ws[i] = Integer.parseInt(inputs[0]);
            Vs[i] = Integer.parseInt(inputs[1]);
        }
        for(int x = 1; x < N+1; x++){                       // 아이템 넘버
            for(int y = 1; y < K+1; y++){                       // 총 무게
                if(y - Ws[x] >= 0) {
                    dp[x][y] = Math.max(dp[x - 1][y], dp[x - 1][y - Ws[x]] + Vs[x]);
                }else{
                    dp[x][y] = dp[x-1][y];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
