package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class BJ1719_P implements Comparable<BJ1719_P>{
    int end, weight;

    BJ1719_P(int a, int b){
        this.end = a;
        this.weight = b;
    }
    public int compareTo(BJ1719_P b){
        return b.weight - this.weight;
    }
}
public class BJ_1719_택배 {
    static StringBuffer sb = new StringBuffer();
    static int n,m;
    static int[] dist, routes;
    static ArrayList<BJ1719_P>[] base;
    static PriorityQueue<BJ1719_P> pq;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        base = new ArrayList[n+1];
        for(int i = 0 ; i < n+1; i++){
            base[i] = new ArrayList<BJ1719_P>();
        }
        for(int i = 0 ; i < m; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]), weight = Integer.parseInt(inputs[2]);
            base[start].add(new BJ1719_P(end, weight));
            base[end].add(new BJ1719_P(start, weight));
        }
        for(int i = 1; i < n+1; i++){
            dijkstra(i);
        }
        System.out.println(sb.toString());
    }
    public static void dijkstra(int start){
        dist = new int[n+1];
        routes = new int[n+1];
        pq = new PriorityQueue<BJ1719_P>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new BJ1719_P(start, 0));
        while(!pq.isEmpty()){
            BJ1719_P now = pq.poll();
            for(BJ1719_P toGo : base[now.end]){
                if(dist[toGo.end] > dist[now.end] + toGo.weight){
                    dist[toGo.end] = dist[now.end] + toGo.weight;
                    routes[toGo.end] = now.end;
                    pq.add(new BJ1719_P(toGo.end, dist[toGo.end]));
                }
            }
        }
        for(int i = 1; i < n+1; i++){
            if (i == start){
                sb.append("- ");
            }else{
                int j = i;
                while(true){
                    int target=  routes[j];
                    if(target == start){
                        sb.append(String.valueOf(j) + " ");
                        break;
                    }else{
                        j = routes[j];
                    }
                }
            }
        }
        sb.append("\n");
    }

}
