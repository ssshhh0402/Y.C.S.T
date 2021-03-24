package Prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11660_구간합5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        int [][] base = new int [N+1][N+1];
        int [][] dp = new int[N+1][N+1];
        for(int x = 1; x < N+1; x++){
            inputs = br.readLine().split(" ");
            for(int y = 1; y < N+1; y++){
                base[x][y] = Integer.parseInt(inputs[y-1]);
            }
        }
        for(int x = 1; x < N+1; x++){
            for(int y = 1; y < N+1; y++){
                dp[x][y] = base[x][y] + dp[x-1][y] + dp[x][y-1] - dp[x-1][y-1];
            }
        }
        for(int m = 0; m < M; m++){
            inputs = br.readLine().split(" ");
            int x1 = Integer.parseInt(inputs[0]), y1 = Integer.parseInt(inputs[1]), x2 = Integer.parseInt(inputs[2]), y2 = Integer.parseInt(inputs[3]);
            sb.append(String.valueOf(dp[x2][y2] + dp[x1-1][y1-1] - dp[x2][y1-1] - dp[x1-1][y2])+ "\n");
        }
        System.out.println(sb.toString());
    }
}
