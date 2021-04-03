package Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1507_궁금한민호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int INF = 987654321;
        int [][] dp = new int [N+1][N+1];
        String [] inputs;
        for(int x = 1; x < N+1; x++){
            inputs = br.readLine().split(" ");
            for(int y = 1; y < N+1; y++){
                dp[x][y] = Integer.parseInt(inputs[y-1]);
            }
        }
        for(int z = 1; z < N+1; z++){
            for(int x = 1; x < N+1; x++){
                for(int y = 1; y < N+1; y++){
                    if(dp[x][y] > dp[x][z] + dp[z][y]){
                    }
                }
            }
        }
    }
}
