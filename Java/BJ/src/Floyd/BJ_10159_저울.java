package Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10159_저울 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean [][] dp = new boolean[N+1][N+1];
        String [] inputs;
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int a =  Integer.parseInt(inputs[0]), b =  Integer.parseInt(inputs[1]);
            dp[a][b] = true;
        }
        for(int z = 1; z < N+1; z++){
            for(int x = 1; x < N+1; x++){
                for(int y = 1; y < N+1; y++){
                    if(dp[x][z] && dp[z][y]){
                        dp[x][y] = true;
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
                if(!dp[x][y] && !dp[y][x]){
                    count += 1;
                }
            }
            sb.append(count + "\n");
        }
        System.out.print(sb.toString());
    }
}
