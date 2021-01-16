package Tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num3 {
    static int n;
    public static int calc(int a, int b, int c, int[][] grid){
        int count = 0;
        for(int x = a; x < a + c; x++){
            for(int y = b; y < b + c; y++){
                count += grid[x][y];
            }
        }
        return count;
    }
    public static int count(int j, int[][] grid){
        int count = 0;
        for(int x = 0 ; x < n - j+1; x++){
            for(int y = 0 ; y < n- j+1; y++){
                int now = calc(x,y,j,grid) ;
                if (now > count){
                    count = now;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int [][] grid =  new int[n][n];
        for(int x = 0 ; x < n; x++){
            String[] inputs = br.readLine().split(" ");
            for(int y = 0 ; y < n; y++){
                grid[x][y] = Integer.parseInt(inputs[y]);
            }
        }
        int maxSum = Integer.parseInt(br.readLine());
        int[]dp = new int[n+1];
        for(int i = 1 ; i < n+1; i++){
            int count = count(i,grid);
            dp[i] = count;
        }
        int answer = 0;
        for(int idx = 1; idx < n + 1; idx++){
            if(dp[idx] <= maxSum){
                answer = idx;
            }
        }
        System.out.println(answer);
    }
}
