package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_3159_뱀 {
    static class Pair{
        int x, y;

        Pair(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
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
            base[x-1][y-1] = 1;
        }
        ArrayList<Pair> snakes = new ArrayList<Pair>();
        snakes.add(new Pair(0,0));
        int L = Integer.parseInt(br.readLine());
        int head_x = 0, head_y = 0, dir = 0, answer = 0;
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        for(int i = 0 ; i < L; i++){
            inputs = br.readLine().split(" ");
            boolean flag = true;
            int T = Integer.parseInt(inputs[0]);
            for(int t= 0; t < T; t++){
                head_x += dx[dir];
                head_y += dy[dir];
                answer += 1;
                if(0 <= head_x && head_x < N && 0 <= head_y && head_y < N){
                    if(base[head_x][head_y] == 1){
                        base[head_x][head_y] = 0;
                        snakes.add(new Pair(head_x, head_y));
                    }else{
                        Pair now = new Pair(head_x, head_y);
                        if(snakes.contains(now)){
                            flag = false;
                            break;
                        }else{
                            snakes.add(now);
                            snakes.remove(0);
                        }
                    }
                }else{
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }else{
                if(inputs[1].charAt(0) == 'D'){
                    dir += 1;
                }else{
                    dir -= 1;
                }
                if(dir == 4){
                    dir = 0;
                }else if(dir < 0){
                    dir = 3;
                }
            }
        }
        System.out.println(answer);
    }
}
