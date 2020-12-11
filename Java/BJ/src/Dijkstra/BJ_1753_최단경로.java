package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    int end, weight;

    Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
    @Override
    public int compareTo(Pair o){
        return weight - o.weight;
    }
}
public class BJ_1753_최단경로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int V= Integer.parseInt(inputs[0]);
        int E = Integer.parseInt(inputs[1]);
        int K = Integer.parseInt(br.readLine());
        ArrayList<Pair>[] base = new ArrayList[V+1];
        int[] dist = new int[V+1];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        boolean[] visited = new boolean[V+1];                           //변수 및 배열 선언
        for(int i=0; i < V+1; i++){
            base[i] = new ArrayList<Pair>();
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0; i < E; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);
            base[start].add(new Pair(end, weight));
        }                                                               //변수 및 배열 초기 상태 설정
        dist[K] = 0;
        pq.add(new Pair(K, 0));                                      //시작 지점 설정
        while(!pq.isEmpty()){
            Pair now = pq.poll();
            int end = now.end;
            if (visited[end]){
                continue;
            }
            visited[end] = true;
            for(Pair next: base[end]){
                if(dist[next.end] > dist[end] + next.weight){
                    dist[next.end] = dist[end] + next.weight;
                    pq.add(new Pair(next.end, dist[next.end]));
                }
            }
        }
        for(int idx = 1; idx < V+1; idx++){
            if(dist[idx] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[idx]);
            }
        }
    }
}

