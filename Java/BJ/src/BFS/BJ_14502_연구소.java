package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_14502_연구소 {
    static String[] inputs;
    static int [][] base;
    static boolean[][] visited;
    static class Pair{
        int x, y, count, sum;

        Pair(int a, int b, int c, int d){
            this.x = a;
            this.y = b;
            this.count = c;
            this.sum = d;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        base = new int[N][M];
        Queue<Pair> q = new LinkedList<Pair>();
        for(int x = 0; x < N; x++){
            inputs = br.readLine().split(" ");
            for(int y = 0 ; y < M ; y++){
                base[x][y] = Integer.parseInt(inputs[y]);
                if(base[x][y] == 2){
                    q.offer(new Pair(x,y,0,0));
                }
            }
        }
        while(!q.isEmpty()){
            for(int i = 0; i < q.size(); i++){
                Pair now = q.poll();
                for(int j = 0; j < 4; j++){
                    int x = now.x+dx[j];
                    int y = now.y + dy[j];
                    if(0 <= x && x < N && 0 <= y && y< M && !visited[x][y]){
                        if(base[x][y] == 0){
                            q.add(new Pair(x,y,now.count,now.sum+1));
                        }
                    }
                }
            }
        }

    }
}
