package Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1058_친구 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] dp = new int[N+1][N+1];
        int [][] base = new int[N+1][N+1];
        int answer=  Integer.MIN_VALUE;
        String[] inputs;
        for(int x = 1; x < N+1; x++){
            inputs = br.readLine().split("");
            for(int y = 1; y < N+1; y++){
                if(inputs[y-1].equals("Y")){
                    dp[x][y]= 1;
                }else if(x != y){
                    dp[x][y] = 987654321;
                }
            }
        }
        for(int z = 1; z < N+1; z++){
            for(int x = 1; x < N+1; x++){
                for(int y = 1; y < N+1; y++){
                    if(dp[x][y] > dp[x][z] + dp[z][y]){
                        dp[x][y] = dp[x][z] + dp[z][y];
                    }
                }
            }
        }
        for(int x = 1; x < N+1; x++){
            int count = 0;
            for(int y = 1; y < N+1; y++){
                if(x == y){
                    continue;
                }
                if(dp[x][y] <= 2){
                    count += 1;
                }
            }
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
    }
}
