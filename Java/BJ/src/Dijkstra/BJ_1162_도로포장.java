package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class BJ1162_Pair implements Comparable<BJ1162_Pair>{
    int end, count;
    long weight;
    BJ1162_Pair(int a, long b, int c){
        this.end = a;
        this.weight = b;
        this.count = c;
    }

    public int compareTo(BJ1162_Pair b){
        return (int)(this.weight - b.weight);
    }
}
public class BJ_1162_도로포장 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]), K = Integer.parseInt(inputs[2]);
        PriorityQueue<BJ1162_Pair> pq = new PriorityQueue<BJ1162_Pair>();
        ArrayList<BJ1162_Pair>[] base = new ArrayList[N+1];
        long [][] dist = new long[N+1][K+1];
        for(int i=  0 ; i < N+1; i++){
            base[i] = new ArrayList<BJ1162_Pair>();
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int start= Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);
            base[start].add(new BJ1162_Pair(end, weight, 0));
            base[end].add(new BJ1162_Pair(start, weight, 0));
        }
        dist[1][0] = 0;
        pq.add(new BJ1162_Pair(1,0,0));
        while(!pq.isEmpty()){
            BJ1162_Pair now = pq.poll();
            if(dist[now.end][now.count] < now.weight){
                continue;
            }
            for(BJ1162_Pair toGo : base[now.end]){
                if(now.count + 1 <= K && dist[toGo.end][now.count+1] > dist[now.end][now.count]){
                    dist[toGo.end][now.count+1] = dist[now.end][now.count];
                    pq.add(new BJ1162_Pair(toGo.end, dist[toGo.end][now.count+1],now.count+1));
                }
                if(dist[toGo.end][now.count] > dist[now.end][now.count] + toGo.weight){
                    dist[toGo.end][now.count] = dist[now.end][now.count] + toGo.weight;
                    pq.add(new BJ1162_Pair(toGo.end, dist[toGo.end][now.count], now.count));
                }
            }
        }
        long answer= Long.MAX_VALUE;
        for(int i = 0 ; i <= K; i++){
            answer = Math.min(answer, dist[N][i]);
        }
        System.out.println(answer);
    }
}
