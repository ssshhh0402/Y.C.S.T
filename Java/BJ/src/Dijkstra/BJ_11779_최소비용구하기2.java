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
        ArrayList<Integer> count = new ArrayList<Integer>();
        String answer = "";

        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new B_Pair2(s,0));
        dist[s] = 0;
        while(!pq.isEmpty()){
            B_Pair2 now = pq.poll();
            for(B_Pair2 toGo : base[now.end]){
                int end = toGo.end;
                int weight = toGo.weight;
                if(dist[end] > dist[now.end] + weight){
                    dist[end] = dist[now.end] + weight;
                    counts[end] = now.end;
                    pq.add(new B_Pair2(end, dist[end]));
                }
            }
        }
        System.out.println(dist[e]);
        while(true){
            count.add(e);
            if(e == s){
                break;
            }
            e = counts[e];
        }
        for(int idx = count.size() - 1; idx >= 0; idx--){
            if(idx == 0){
                answer += count.get(idx);
            }else{
                answer += count.get(idx) + " ";
            }
        }
        System.out.println(count.size());
        System.out.println(answer);
    }
}
