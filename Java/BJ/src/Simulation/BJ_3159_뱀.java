package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3159_뱀 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs;
        int N = Integer.parseInt(br.readLine());
        int [][] base = new int[N][N];
        int K = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < K; i++){
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            base[x][y] = 1;
        }
        int L = Integer.parseInt(br.readLine());
        int head_x = 0, head_y = 0, tail_x = 0, tail_y = 0, dir = 0;
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        for(int i = 0 ; i < L; i++){
            inputs = br.readLine().split(" ");
            int T = Integer.parseInt(inputs[0]);
            for(int t= 0; t < T; t++){

            }
        }
    }
}
