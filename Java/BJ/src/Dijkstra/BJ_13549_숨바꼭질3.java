package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class S_Pair implements Comparable<S_Pair>{
    int end, weight;

    S_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
    public int compareTo(S_Pair s){
        return this.weight - s.weight;
    }
}
public class BJ_13549_숨바꼭질3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        PriorityQueue<S_Pair> pq = new PriorityQueue<S_Pair>();
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[] dist = new int[1000001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new S_Pair(N, 0));
        dist[N] = 0;
        while(!pq.isEmpty()){
            S_Pair now = pq.poll();
            if(now.end + 1 < 1000000 && dist[now.end+1] > dist[now.end] + 1){
                dist[now.end+1] = dist[now.end] + 1;
                pq.add(new S_Pair(now.end+1, dist[now.end+1]));
            }
            if(now.end - 1 >= 0 && now.end - 1 <= 1000000 && dist[now.end-1] > dist[now.end] + 1){
                dist[now.end-1] = dist[now.end] + 1;
                pq.add(new S_Pair(now.end-1, dist[now.end - 1]));
            }
            if(now.end * 2 >= 0 && now.end * 2 <= 1000000 && dist[now.end * 2] > dist[now.end]){
                dist[now.end * 2] = dist[now.end];
                pq.add(new S_Pair(now.end*2, dist[now.end*2]));
            }
        }
        System.out.println(dist[M]);

    }
}
