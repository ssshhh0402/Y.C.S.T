package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class T_Pair implements Comparable<T_Pair>{
    int end, weight;
    T_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
    public int compareTo(T_Pair t){
        return this.weight - t.weight;
    }
}

public class BJ_1504_특정한최단경로 {
    public static int dijk(int start, int target, int N, ArrayList<T_Pair>[] base){
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N+1];
        PriorityQueue<T_Pair> pq = new PriorityQueue<T_Pair>();
        dist[start] = 0;
        pq.add(new T_Pair(start, 0));
        visited[start] = true;
        while(!pq.isEmpty()){
            T_Pair now = pq.poll();
            for(T_Pair toGo: base[now.end]){
                int next = toGo.end;
                int weight = toGo.weight;
                if(!visited[next] && dist[next] > dist[now.end] + weight){
                    dist[next]  = dist[now.end] + weight;
                    visited[next] = true;
                    pq.add(new T_Pair(next, dist[next]));
                }

            }
        }
        return dist[target];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int E = Integer.parseInt(inputs[1]);
        ArrayList<T_Pair>[] base = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++){
            base[i] = new ArrayList<T_Pair>();
        }
        for(int i = 0; i < E; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);
            base[start].add(new T_Pair(end, weight));
        }
        inputs = br.readLine().split(" ");
        int v1 = Integer.parseInt(inputs[0]);
        int v2 = Integer.parseInt(inputs[1]);
        int answer = 0;
        int answer2 = 0;
        int first = dijk(1,v1,N,base);
        int second = dijk(v1,v2,N,base);
        int third = dijk(v2,N,N,base);
        if(first == Integer.MAX_VALUE || second == Integer.MAX_VALUE || third == Integer.MAX_VALUE){
            answer = 0;
        }else{
            answer = first + second + third;
        }
        first = dijk(1,v2,N,base);
        second = dijk(v2,v1,N,base);
        third = dijk(v1,N,N,base);
        if(first == Integer.MAX_VALUE || second == Integer.MAX_VALUE || third == Integer.MAX_VALUE) {
            answer2 = 0;
        }else{
            answer2 = first + second + third;;
        }
        if(answer == 0 && answer2 == 0){
            System.out.println(-1);
        }else if(answer == 0){
            System.out.println(answer2);
        }else if(answer2 == 0){
            System.out.println(answer);
        }else{
            System.out.println(Math.min(answer, answer2));
        }

    }
}
