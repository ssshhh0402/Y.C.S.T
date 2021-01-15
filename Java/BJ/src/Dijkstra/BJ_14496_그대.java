package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ_14496_그대 {
    static int N,M;
    static String [] inputs;
    static ArrayList<Integer>[] base;
    static class Pair implements Comparable<Pair>{
        int end, weight;

        Pair(int a, int b){
            this.end = a;
            this.weight = b;
        }

        public int compareTo(Pair p){
            return this.weight - p.weight;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        base = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]);
            base[start].add(end);
            base[end].add(start);
        }
        int answer = find(a, b);
        System.out.println(answer);
    }
    static int find(int start, int end){
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Pair(start, 0));
        while(!pq.isEmpty()){
            Pair now = pq.poll();
            if(now.end == end){
                continue;
            }
            for(Integer toGo : base[now.end]){
                if(dist[toGo] > dist[now.end] + 1){
                    dist[toGo] = dist[now.end] + 1;
                    pq.add(new Pair(toGo, dist[toGo]));
                }
            }
        }
        if(dist[end] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[end];
        }
    }
}
