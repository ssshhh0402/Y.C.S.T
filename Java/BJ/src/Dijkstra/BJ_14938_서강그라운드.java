package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class BJ14938_Pair implements Comparable<BJ14938_Pair>{
    int end, weight;

    BJ14938_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
    public int compareTo(BJ14938_Pair b){
        return this.weight - b.weight;
    }

}
public class BJ_14938_서강그라운드 {
    static int n,m,r,count;
    static ArrayList<BJ14938_Pair>[] base;
    static int[] items;
    static int [] dist;
    static boolean [] visited;
    static PriorityQueue<BJ14938_Pair> pq;
    public static int dijkstra(int start){
        count = 0;
        pq = new PriorityQueue<BJ14938_Pair>();
        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new BJ14938_Pair(start, 0));
        while(!pq.isEmpty()){
            BJ14938_Pair now = pq.poll();
            for(BJ14938_Pair toGo : base[now.end]){
                if(dist[toGo.end] > now.weight + toGo.weight && now.weight + toGo.weight <= m){
                    dist[toGo.end] = now.weight + toGo.weight;
                    pq.add(new BJ14938_Pair(toGo.end, dist[toGo.end]));
                }
            }
        }
        for(int i = 1; i < n+1; i++){
            if(dist[i] != Integer.MAX_VALUE){
                count += items[i];
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs=  br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m= Integer.parseInt(inputs[1]);
        r = Integer.parseInt(inputs[2]);
        items = new int[n+1];
        inputs = br.readLine().split(" ");
        base = new ArrayList[n+1];
        PriorityQueue<BJ14938_Pair> pq = new PriorityQueue<BJ14938_Pair>();
        for(int i = 0 ; i < n+1; i++){
            base[i] = new ArrayList<BJ14938_Pair>();
        }
        for(int i = 0; i < n; i++){
            items[i+1] = Integer.parseInt(inputs[i]);
        }
        for(int i = 0 ; i < r; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]), weight = Integer.parseInt(inputs[2]);
            base[start].add(new BJ14938_Pair(end, weight));
            base[end].add(new BJ14938_Pair(start, weight));
        }
        int answer = 0;
        for(int i = 1 ; i < n+1; i++){
            answer = Math.max(answer, dijkstra(i));
        }
        System.out.println(answer);
    }
}
