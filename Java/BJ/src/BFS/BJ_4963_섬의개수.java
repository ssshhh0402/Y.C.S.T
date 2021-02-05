package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_4963_섬의개수 {
    static int n, m;
    static String [] inputs;
    static int [][] base;
    static boolean [][] visited;
    static int [] dx = {0,1,0,-1,-1,-1,1,1};
    static int [] dy = {1,0,-1,0,-1,1,-1,1};
    static class Pair{
        int x, y;

        Pair(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    public static void bfs(int a, int b){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(a,b));
        while(!q.isEmpty()){
            Pair now = q.poll();
            for(int i = 0; i < 8; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if(0 <= x && x < n && 0 <= y && y < m){
                    if(!visited[x][y] && base[x][y] == 1){
                        visited[x][y] = true;
                        q.add(new Pair(x,y));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            inputs = br.readLine().split(" ");
            m = Integer.parseInt(inputs[0]);
            n= Integer.parseInt(inputs[1]);
            if(n == 0 && m == 0){
                break;
            }
            visited = new boolean[n][m];
            base = new int[n][m];
            int count = 0;
            for(int x = 0; x < n; x++){
                inputs = br.readLine().split(" ");
                for(int y = 0 ; y < m; y++){
                    base[x][y] = Integer.parseInt(inputs[y]);
                }
            }
            for(int x = 0; x < n; x++){
                for(int y = 0 ; y < m; y++){
                    if(!visited[x][y] && base[x][y] == 1){
                        visited[x][y] = true;
                        count += 1;
                        bfs(x,y);
                    }
                }
            }
            sb.append(String.valueOf(count) + "\n");
        }
        System.out.println(sb.toString());
    }
}
