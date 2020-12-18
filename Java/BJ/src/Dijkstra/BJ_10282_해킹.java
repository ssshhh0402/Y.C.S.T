package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class H_Pair implements Comparable<H_Pair>{
    int end, weight;

    H_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
    public int compareTo(H_Pair h){
        return this.weight - h.weight;
    }
}
public class BJ_10282_해킹 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String answer = "";
        while(T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int d = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);
            PriorityQueue<H_Pair> pq = new PriorityQueue<H_Pair>();
            ArrayList<H_Pair>[] base = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                base[i] = new ArrayList<H_Pair>();
            }
            for (int i = 0; i < d; i++) {
                inputs = br.readLine().split(" ");
                int start = Integer.parseInt(inputs[0]);
                int end = Integer.parseInt(inputs[1]);
                int weight = Integer.parseInt(inputs[2]);
                base[end].add(new H_Pair(start, weight));
            }
            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            pq.add(new H_Pair(c,0));
            dist[c] = 0;
            int weights = 0;
            int count = 0;
            while (!pq.isEmpty()) {
                H_Pair now = pq.poll();
                int a = now.end;
                int b = now.weight;
                for(H_Pair toGo : base[now.end]){
                    int x = toGo.end;
                    int y = toGo.weight;
                    if(dist[toGo.end] > b + toGo.weight){
                        dist[toGo.end] = b + toGo.weight;
                        pq.add(new H_Pair(toGo.end, dist[toGo.end]));
                    }
                }
            }
            for(int i = 0; i < n+1; i++){
                if (dist[i] != Integer.MAX_VALUE){
                    count += 1;
                    weights = Math.max(weights, dist[i]);
                }
            }
            answer += count + " " + weights + "\n";
        }
        System.out.println(answer);
    }
}
