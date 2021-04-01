package Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1613_역사 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        boolean [][] dp = new boolean[N+1][N+1];
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]);
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
        int S = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < S; i++){
            inputs = br.readLine().split(" ");
            int A = Integer.parseInt(inputs[0]), B = Integer.parseInt(inputs[1]);
            if(!dp[A][B] && !dp[B][A]){
                sb.append(0 + "\n");
            }else{
                if(dp[A][B]){
                    sb.append(-1 + "\n");
                }else{
                    sb.append(1 + "\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}
