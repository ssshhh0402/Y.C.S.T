package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1890_점프 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [][] dp = new long [N][N];
        int [][] base = new int[N][N];
        int [] dx = {0,1};
        int [] dy = {1,0};
        String [] inputs;
        for(int x = 0; x < N; x++){
            inputs = br.readLine().split(" ");
            for(int y = 0 ; y < N; y++){
                base[x][y] = Integer.parseInt(inputs[y]);
            }
        }
        dp[0][0] = 1;
        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                if(x == (N-1) && y == (N-1)){
                    continue;
                }
                int target = base[x][y];
                for(int i = 0; i < 2; i++){
                    if(x + (target * dx[i]) < N && y + (target * dy[i]) < N){
                        dp[x+(target * dx[i])][y + (target * dy[i])] += dp[x][y];
                    }
                }

            }
        }
        System.out.print(dp[N-1][N-1]);
    }
}
