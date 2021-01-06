package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class BJ1162_Pair implements Comparable<BJ1162_Pair>{
    int end, weight, count;

    BJ1162_Pair(int a, int b, int c){
        this.end = a;
        this.weight = b;
        this.count = c;
    }

    public int compareTo(BJ1162_Pair b){
        return this.weight - b.weight;
    }
}
public class BJ_1162_도로포장 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]), K = Integer.parseInt(inputs[2]);
        ArrayList<BJ1162_Pair>[] base = new ArrayList[N+1];
        for(int i=  0 ; i < N+1; i++){
            base[i] = new ArrayList<BJ1162_Pair>();
        }
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int start= Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);
            base[start].add(new BJ1162_Pair(end, weight, 1));
            base[end].add(new BJ1162_Pair(end, weight, 1));
        }
        int [] dist = new int[N+1];
        PriorityQueue<BJ1162_Pair> pq = new PriorityQueue<BJ1162_Pair>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.add(new BJ1162_Pair(1,0,0));
        while(!pq.isEmpty()){
            BJ1162_Pair now = pq.poll();
            for(BJ1162_Pair toGo : base[now.end]){
                if()
            }
        }
    }
}
