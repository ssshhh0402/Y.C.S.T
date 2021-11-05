package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1913_달팽이 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int [][] base = new int[N][N];
        int x = N/2, y = N/2;
        int limit = 1;
        int count = 0;
        int counting = 0;
        int dir = 0;
        int answer_x = 0, answer_y = 0;
        int [] dx = new int[]{-1,0,1,0}, dy = new int [] {0,1,0,-1};
        int value = 1;
        while(value != (N*N+1)){
            base[x][y] = value;
            if(value == M){
                answer_x = x;
                answer_y = y;
            }
            if(count == limit){
                count = 1;
                dir = (dir+1) % 4;
                counting += 1;
                if(counting == 2){
                    limit += 1;
                    counting = 0;
                }
            }else{
                count += 1;
            }
            x += dx[dir];y += dy[dir];
            value += 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(base[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append((answer_x+1) + " "  + (answer_y+1));
        System.out.println(sb.toString());

    }
}
