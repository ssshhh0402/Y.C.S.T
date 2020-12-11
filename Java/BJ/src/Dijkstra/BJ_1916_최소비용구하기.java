package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class B_Pair implements Comparable<B_Pair>{
    int end, weight;

    B_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
    @Override
    public int compareTo(B_Pair p){
        return this.weight - p.weight;
    }
}
public class BJ_1916_최소비용구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        PriorityQueue<B_Pair> pq = new PriorityQueue<B_Pair>();
        ArrayList<B_Pair>[] base = new ArrayList[N+1];
        boolean [] visited= new boolean[N+1];
        int[] dist = new int [N+1];
        for(int i = 0; i < N+1; i++){
            base[i] = new ArrayList<B_Pair>();
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i = 0; i < M; i++){
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);
            base[start].add(new B_Pair(end, weight));
        }
        String[] inputs = br.readLine().split(" ");
        int s = Integer.parseInt(inputs[0]);
        int e = Integer.parseInt(inputs[1]);
        pq.add(new B_Pair(s, 0));
        dist[s] = 0;
        while(!pq.isEmpty()){
            B_Pair now = pq.poll();
            if(visited[now.end]){
                continue;
            }
            visited[now.end] = true;
            for(B_Pair toGo : base[now.end]){
                int end = toGo.end;
                int weight = toGo.weight;
                if(dist[end] > dist[now.end] + weight){
                    dist[end] = dist[now.end] + weight;
                    pq.add(new B_Pair(end, dist[now.end] + weight));
                }
            }
        }
        System.out.println(dist[e]);
    }
}
