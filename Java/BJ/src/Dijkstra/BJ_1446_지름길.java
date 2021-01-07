package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class BJ1446_Pair implements Comparable<BJ1446_Pair>{
    int end,weight;
    BJ1446_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }

    public int compareTo(BJ1446_Pair b){
        return this.weight - b.weight;
    }
}
public class BJ_1446_지름길 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), D = Integer.parseInt(inputs[1]), answer = Integer.MAX_VALUE;
        ArrayList<Integer> starts = new ArrayList<Integer>();
        PriorityQueue<BJ1446_Pair> pq = new PriorityQueue<BJ1446_Pair>();
        ArrayList<BJ1446_Pair>[] base = new ArrayList[D+1];
        for(int i = 0 ; i < D+1; i++){
            base[i] = new ArrayList<BJ1446_Pair>();
        }
        for(int i = 0; i < N; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]), weight = Integer.parseInt(inputs[2]);
            if(start <= D && end <= D){
                if(!starts.contains(start)){
                    starts.add(start);
                }
                base[start].add(new BJ1446_Pair(end, weight));
                base[end].add(new BJ1446_Pair(start, weight));
            }
        }
        int[] dist = new int[D+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new BJ1446_Pair(0,0));
        while(!pq.isEmpty()){
            BJ1446_Pair now = pq.poll();
            if(now.end + 1 <= D && dist[now.end+1] > dist[now.end] + 1){
                dist[now.end+1] = dist[now.end] + 1;
                pq.add(new BJ1446_Pair(now.end+1, dist[now.end+1]));
            }
            for (BJ1446_Pair toGo : base[now.end]) {
                if (toGo.end <= D && dist[toGo.end] > dist[now.end] + toGo.weight) {
                    dist[toGo.end] = dist[now.end] + toGo.weight;
                    pq.add(new BJ1446_Pair(toGo.end, dist[toGo.end]));
                }
            }
        }
        System.out.println(dist[D]);
    }
}
