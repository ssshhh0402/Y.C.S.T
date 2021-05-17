package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1937_판다 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] base = new int [n+1][n+1];
        int [][] dp = new int[n+1][n+1];
        int [] dx = {0,1,0,-1}, dy = {1,0,-1,0};
        String[] inputs;
        for(int x = 1; x < n+1; x++){
            inputs = br.readLine().split(" ");
            for(int y = 1; y < n+1; y++){
                base[x][y] = Integer.parseInt(inputs[y-1]);
            }
        }
        int answer = 0;
        for(int x = 0;  x< n; x++){
            for(int y = 0 ; y < n; y++){
                for(int i = 0 ; i < 4; i++){
                    int a = x + dx[i], b = y + dy[i];
                    if(0 <= a && a < n+1 && 0 <= b && b < n+1){
                        if(base[x][y] < base[a][b]){
                            dp[x][y] = Math.max(dp[x][y], dp[a][b] + 1);
                        }
                    }
                }
                answer = Math.max(answer, dp[x][y]);
            }
        }
        System.out.println(answer+1);
    }
}
