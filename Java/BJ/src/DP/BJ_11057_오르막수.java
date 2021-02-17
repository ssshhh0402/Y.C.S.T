package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11057_오르막수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] base = new int[N+1][10];
        int answer = 0;
        for(int x = 1; x < N+1; x++){
            base[x][0] = 1;
            for(int y = 1; y < 10; y++){
                if(x == 1){
                    base[x][y] = 1;
                }else {
                    base[x][y] = (base[x - 1][y] + base[x][y - 1]) % 10007;
                }
            }
        }
        for(int i = 0; i < 10; i++){
            answer += base[N][i];
        }
        System.out.println(answer % 10007);
    }
}
