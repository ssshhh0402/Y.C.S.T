package Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2458_키순서 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        int answer = 0;
        int infs = 501;
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        int [][] dp = new int[N+1][N+1];
        for(int x = 0 ; x < N; x++){
            Arrays.fill(dp[x],infs);
        }
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]);
            dp[a][b] = 1;
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
        int [] count = new int[N+1];
        for(int x = 1; x < N+1; x++){
            for(int y = 1; y < N+1; y++){
                if(x == y){
                    continue;
                }
                if(dp[x][y] != infs && dp[x][y] != infs){
                    count[x] += 1;
                    count[y] += 1;

                }
            }
        }
        for(int i = 1; i < N+1; i++){
            if(count[i] == (N-1)){
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
