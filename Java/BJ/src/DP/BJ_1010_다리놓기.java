package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1010_다리놓기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int [][] base;
        String[] inputs;
        for(int t = 0 ; t < T; t++){
            inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);
            base = new int[n+1][m+1];
            for(int i = 1; i < m+1; i++){
                base[1][i] = i;
            }
            for(int x = 2; x < n+1; x++){
                for(int y = 2; y < m+1; y++){
                    base[x][y] = base[x][y-1] + base[x-1][y-1];
                }
            }
            sb.append(base[n][m] + "\n");
        }
        System.out.println(sb.toString());
    }
}
