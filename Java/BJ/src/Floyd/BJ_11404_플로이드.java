package Floyd;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ_11404_플로이드 {
    static ArrayList<Pair>[] base;
    static long [] dist;
    static int N;
    static PriorityQueue<Pair> pq;
    static class Pair implements Comparable<Pair>{
        int end;
        long weight;

        Pair(int a, long b){
            this.end = a;
            this.weight = b;
        }
        public int compareTo(Pair p){
            return (int)(this.weight - p.weight);
        }
    }
    public static void dijk(int start){
        pq = new PriorityQueue<Pair>();
        pq.add(new Pair(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Pair now = pq.poll();
            for(Pair toGo : base[now.end]){
                if(dist[toGo.end] > now.weight + toGo.weight){
                    dist[toGo.end] = now.weight + toGo.weight;
                    pq.add(new Pair(toGo.end, dist[toGo.end]));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        base = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++){
            base[i] = new ArrayList<Pair>();
        }
        dist = new long [N+1];
        String [] inputs;
        for(int i = 0; i < m; i++){
            inputs = br.readLine().split(" ");
            int s = Integer.parseInt(inputs[0]), e = Integer.parseInt(inputs[1]), w = Integer.parseInt(inputs[2]);
            base[s].add(new Pair(e, w));
        }
        for(int i = 1; i < N+1; i++){
            Arrays.fill(dist, Long.MAX_VALUE);
            dijk(i);
            for(int j = 1 ; j < N+1; j++){
                if(dist[j] != Long.MAX_VALUE){
                    sb.append(dist[j] + " ");
                }else{
                    sb.append(0 + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
