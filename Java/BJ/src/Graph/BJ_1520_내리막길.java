package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1520_내리막길 {
    static int M, N;
    static int [] dx = new int [] {0,1,0,-1};
    static int [] dy = new int [] {1,0,-1,0};
    static int [][] base, dp;
    public static int solution(int a, int b){
        if(a == (M-1) && b == (N-1)){
            return 1;
        }
        if(dp[a][b] == -1){
            dp[a][b] = 0;
            for(int i = 0 ; i < 4; i++){
                int x = a + dx[i];
                int y = b + dy[i];
                if(0 <= x && x < M && 0 <= y && y < N){
                    if(base[x][y] < base[a][b]){
                        dp[a][b] += solution(x,y);
                    }
                }
            }
        }
        return dp[a][b];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        M = Integer.parseInt(inputs[0]);
        N = Integer.parseInt(inputs[1]);
        base = new int[M][N];
        dp = new int[M][N];
        for(int x = 0; x < M; x++){
            inputs = br.readLine().split(" ");
            for(int y = 0; y < N; y++){
                base[x][y] = Integer.parseInt(inputs[y]);
                dp[x][y] = -1;
            }
        }
        int answer = solution(0,0);
        System.out.println(solution(0,0));
    }
}
