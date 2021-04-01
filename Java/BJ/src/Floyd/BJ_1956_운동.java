package Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1956_운동 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int max = 10001;;
        int answer = Integer.MAX_VALUE;
        int V = Integer.parseInt(inputs[0]), E = Integer.parseInt(inputs[1]);
        int [][] dp = new int [V+1][V+1];
        for(int i = 1; i < V+1; i++){
            Arrays.fill(dp[i], max);
        }
        for(int i = 0 ; i < E; i++){
            inputs = br.readLine().split(" ");
            int s = Integer.parseInt(inputs[0]), e = Integer.parseInt(inputs[1]), w = Integer.parseInt(inputs[2]);
            dp[s][e] = w;
        }
        for(int z = 1; z < V+1; z++){
            for(int x = 1; x < V+1; x++){
                for(int y = 1; y < V+1; y++){
                    if(x == y){
                        continue;
                    }
                    if(dp[x][y] > dp[x][z] + dp[z][y]){
                        dp[x][y] = dp[x][z] + dp[z][y];
                    }
                }
            }
        }
        for(int x = 1; x < V+1; x++){
            for(int y = 1; y < V+1; y++){
                if(x == y){
                    continue;
                }
                if(dp[x][y] != max && dp[y][x] != max){
                    answer = Math.min(answer, dp[x][y] + dp[y][x]);
                }
            }
        }
        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }
    }
}
