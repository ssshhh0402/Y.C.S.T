package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class N_Pair implements Comparable<N_Pair>{
    int end, weight;

    N_Pair(int a, int b){
        this.end = a;
        this.weight = b ;
    }
    public int compareTo(N_Pair n){
        return this.weight - n.weight;
    }
}
public class BJ_2211_네트워크복구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        ArrayList<N_Pair>[] base = new ArrayList[N+1];
        int [] routes = new int[N+1];
        PriorityQueue<N_Pair> pq = new PriorityQueue<N_Pair>();
        for(int i = 0 ; i < N+1; i++){
            base[i] = new ArrayList<N_Pair>();
        }
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);
            base[start].add(new N_Pair(end, weight));
            base[end].add(new N_Pair(start, weight));
        }
        int[] dist= new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.add(new N_Pair(1,0));
        while(!pq.isEmpty()){
            N_Pair now  = pq.poll();
            for(N_Pair toGo : base[now.end]){
                if(dist[toGo.end] > now.weight + toGo.weight){
                    dist[toGo.end] = now.weight + toGo.weight;
                    routes[toGo.end] = now.end;
                    pq.add(new N_Pair(toGo.end, dist[toGo.end]));
                }
            }
        }
        String answer = "";
        int count = 0;
        for(int i = 0 ; i < N+1; i++){
            if(dist[i] != Integer.MAX_VALUE && dist[i] != 0){
                answer += i + " " + String.valueOf(routes[i]) + "\n";
                count+= 1;
            }
        }
        System.out.println(count +"\n" + answer);
    }
}
