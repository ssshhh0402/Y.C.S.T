package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class P_Pair implements Comparable<P_Pair>{
    int end, weight;
    P_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
    public int compareTo(P_Pair p){
        return this.weight - p.weight;
    }
        }
public class BJ_1238_파티 {
    static ArrayList<P_Pair>[] base;
    static PriorityQueue<P_Pair> pq;
    public static int dijk(int start, int end, int N){
        pq = new PriorityQueue<P_Pair>();
        int[] dist = new int[N+1];
        boolean [] visited = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new P_Pair(start, 0));
        while(!pq.isEmpty()){
            P_Pair now = pq.poll();
            if(visited[now.end]){
                continue;
            }
            visited[now.end] = true;
            for(P_Pair toGo : base[now.end]){
                int next = toGo.end;
                int weight = toGo.weight;
                if(dist[next] > dist[now.end] + weight){
                    dist[next] = dist[now.end] + weight;
                    pq.add(new P_Pair(next, dist[next]));
                }
            }
        }
        return dist[end];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int X = Integer.parseInt(inputs[2]);
        int [] temps = new int [N+1];
        int answer = Integer.MIN_VALUE;
        base = new ArrayList[N+1];
        for(int idx = 0; idx < N+1; idx++){
            base[idx] = new ArrayList<P_Pair>();
        }
        for(int idx = 0; idx < M; idx++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);
            base[start].add(new P_Pair(end, weight));
        }
        for(int idx = 1; idx < N+1; idx++){
            temps[idx] = dijk(idx,X,N) + dijk(X,idx,N);
        }
        for(int item : temps) {
            answer = Math.max(answer, item);
        }
        System.out.println(answer);
    }
}
