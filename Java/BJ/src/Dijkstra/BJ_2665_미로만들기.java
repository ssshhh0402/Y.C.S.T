package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
class M_Pair implements Comparable<M_Pair>{
    int x, y, weight;

    M_Pair(int a, int b, int c){
        this.x = a;
        this.y = b;
        this.weight = c;
    }
    public int compareTo(M_Pair m){
        return this.weight - m.weight;
    }
}
public class BJ_2665_미로만들기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs;
        int N= Integer.parseInt(br.readLine());
        int [] temps = new int[] {1,0};
        int [][] base = new int[N][N];
        int [][] dist = new int[N][N];
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[] {1,0,-1,0};
        for(int x = 0; x < N; x++){
            inputs = br.readLine().split("");
            for(int y = 0; y < N; y++){
                base[x][y] = temps[Integer.parseInt(inputs[y])];
            }
            Arrays.fill(dist[x], Integer.MAX_VALUE);
        }
        PriorityQueue<M_Pair> pq = new PriorityQueue<M_Pair>();
        pq.add(new M_Pair(0,0,0));
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            M_Pair now = pq.poll();
            for(int i = 0 ; i < 4; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if (0<= x && x < N && 0 <= y && y < N){
                    if(dist[x][y] > dist[now.x][now.y] + base[x][y]){
                        dist[x][y] = dist[now.x][now.y] + base[x][y];
                        pq.add(new M_Pair(x,y,dist[x][y]));
                    }
                }
            }
        }
        System.out.println(dist[N-1][N-1]);
    }
}
