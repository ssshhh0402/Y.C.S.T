package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class B_Pair2 implements Comparable<B_Pair2>{
    int end, weight;
    B_Pair2(int a, int b){
        this.end = a;
        this.weight = b;
    }
    public int compareTo(B_Pair2 b){
        return this.weight - b.weight;
    }
}


public class BJ_11779_최소비용구하기2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] dist= new int[n+1];
        int[] counts = new int[n+1];
        int count = 0;
        String answer = "";
        ArrayList<B_Pair2>[] base = new ArrayList[n+1];
        PriorityQueue<B_Pair2> pq = new PriorityQueue<B_Pair2>();
        for(int i = 0; i < n+1; i++){
            base[i] = new ArrayList<B_Pair2>();
        }
        for(int i= 0; i < m; i++){
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);
            base[start].add(new B_Pair2(end, weight));
        }
        String[] inputs = br.readLine().split(" ");
        int s = Integer.parseInt(inputs[0]);
        int e = Integer.parseInt(inputs[1]);
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new B_Pair2(s,0));
        dist[s] = 0;
        while(!pq.isEmpty()){
            B_Pair2 now = pq.poll();
            int cur = now.end;
            int c_weight = now.weight;
            for(B_Pair2 toGo : base[cur]){
                int end = toGo.end;
                int weight = toGo.weight;
                if(dist[end] > dist[cur] + weight){
                    dist[end] = dist[cur] + weight;
                    counts[end] = now.end;
                    pq.add(new B_Pair2(end, dist[end]));
                }
            }
        }
        System.out.println(dist[e]);
        int idx = e;
        while(idx != s){
            int now = counts[idx];
            if(now == s){
                answer += now;
                break;
            }else{
                answer += now + " ";
                idx = now;
            }
            count += 1;
        }
        System.out.println(count);
        System.out.println(answer);
    }
}
