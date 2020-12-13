package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class R_Pair implements Comparable<R_Pair>{
    int x,y,count;
    R_Pair(int a, int b, int c) {
        this.x = a;
        this.y = b;
        this.count = c;
    }
    public int compareTo(R_Pair r){
        return this.count - r.count;
    }
}

public class BJ_1261_알고스팟 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int M= Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        int[][] base = new int[N][M];
        PriorityQueue<R_Pair> pq = new PriorityQueue<R_Pair>();
        int [][] dist = new int[N][M];
        for(int x = 0; x < N; x++){
            Arrays.fill(dist[x], Integer.MAX_VALUE);
        }
        for(int x = 0; x < N; x++){
            String temps = br.readLine();
            for(int y=0; y < M; y++){
                base[x][y] = temps.charAt(y)-'0';
            }
        }
        dist[0][0] = 0;
        pq.add(new R_Pair(0,0,0));
        while(!pq.isEmpty()){
            R_Pair now = pq.poll();
            for(int i = 0; i < 4; i++){
                int n_x = now.x + dx[i];
                int n_y = now.y + dy[i];
                if(0 <= n_x && n_x< N && 0 <= n_y && n_y < M){
                    if(dist[n_x][n_y] > dist[now.x][now.y] + base[n_x][n_y]){
                        dist[n_x][n_y] = dist[now.x][now.y] + base[n_x][n_y];
                        pq.add(new R_Pair(n_x, n_y, dist[n_x][n_y]));
                    }
                }
            }
        }
        System.out.println(dist[N-1][M-1]);
    }
}
