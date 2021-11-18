package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1952_달팽이2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        int [] dx = new int[] {0,1,0,-1}, dy = new int [] {1,0,-1,0};
        int [][] base = new int[N][M];
        int x = 0, y = 0, dir = 0;
        int answer = 0;
        int value = 1;
        while(value != N*M){
            base[x][y] = value;
            if(!(0<=x+dx[dir] && x+dx[dir] < N && 0<= y + dy[dir] && y+dy[dir] < M && base[x+dx[dir]][y+dy[dir]] == 0)){
                dir = (dir+1) % 4;
                answer += 1;
            }
            x += dx[dir];
            y += dy[dir];
            value += 1;
        }
        System.out.println(answer);
    }
}
