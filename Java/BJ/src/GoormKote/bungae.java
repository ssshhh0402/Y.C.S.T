package GoormKote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bungae {
    static class Pair{
        int x, y, count;

        Pair(int a, int b, int c){
            this.x = a;
            this.y= b;
            this.count = c;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs;
        inputs = br.readLine().split(" ");
        int M = Integer.parseInt(inputs[0]);    //가로
        int N = Integer.parseInt(inputs[1]);        //세로
        String [][] base = new String[N][M];
        Queue<Pair> q = new LinkedList<Pair>();
        int [] dx = {0,0};        //좌, 우
        int [] dy = {1,-1};
        int answer = Integer.MAX_VALUE;
        boolean [][] visited = new boolean[N][M];
        for(int x = 0; x < N; x++){
            inputs = br.readLine().split("");
            for(int y = 0; y < M; y++){
                base[x][y] = inputs[y];
                if(base[x][y].equals("c")){
                    visited[x][y] = true;
                    q.add(new Pair(x,y,0));

                }
            }
        }
        while(!q.isEmpty()){
            Pair now = q.poll();
            if(now.x == (N-1)){
                answer = Math.min(answer, now.count);
            }
            for(int i = 0; i < 2; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if(0 <= x && x < N && 0 <= y && y < M && !base[x][y].equals("x")){
                    if(!visited[x][y]){
                        visited[x][y] = true;
                        q.add(new Pair(x,y,now.count+1));
                    }
                }
            }
            if(now.x + 1 >= 0 && now.x+1 < N && !base[now.x+1][now.y].equals("x")){
                if(!visited[now.x+1][now.y]){
                    visited[now.x+1][now.y] = true;
                    q.add(new Pair(now.x+1, now.y, now.count));
                }
            }
        }
        if(answer == Integer.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(answer);
        }
    }
}
