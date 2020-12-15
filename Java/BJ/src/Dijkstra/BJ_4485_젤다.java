package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class J_Pair implements Comparable<J_Pair>{
    int x,y, weight;

    J_Pair(int a, int b,int c){
        this.x = a;
        this.y = b;
        this.weight = c;
    }
    public int compareTo(J_Pair j){
        return this.weight - j.weight;
    }
}

public class BJ_4485_젤다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = new int[] {0,1,0,-1};
        int[] dy = new int[] {1,0,-1,0};
        int count = 1;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                break;
            }else{
                int[][] base = new int [N][N];
                int[][] dist = new int[N][N];
                PriorityQueue<J_Pair> pq = new PriorityQueue<J_Pair>();
                for(int x = 0; x < N; x++){
                    Arrays.fill(dist[x], Integer.MAX_VALUE);
                    String[] inputs = br.readLine().split(" ");
                    for(int y = 0; y < N; y++){
                        base[x][y] = Integer.parseInt(inputs[y]);
                    }
                }
                dist[0][0] = base[0][0];
                pq.add(new J_Pair(0,0,base[0][0]));
                while(!pq.isEmpty()){
                    J_Pair now = pq.poll();
                    for(int idx = 0; idx < 4; idx++){
                        int x = now.x + dx[idx];
                        int y = now.y + dy[idx];
                        if(0 <= x && x < N && 0 <= y && y < N){
                            if (dist[x][y] > now.weight + base[x][y]){
                                dist[x][y] = now.weight + base[x][y];
                                pq.add(new J_Pair(x,y,dist[x][y]));
                            }
                        }
                    }
                }
                System.out.println("Problem " + count + ": " + dist[N-1][N-1]);
            }
            count += 1;
        }
    }
}
