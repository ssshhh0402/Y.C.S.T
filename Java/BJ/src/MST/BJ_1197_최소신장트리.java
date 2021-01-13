package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

public class BJ_1197_최소신장트리 {
    static String[] inputs;
    static class Pair implements Comparable<Pair>{
        int end, weight;

        Pair(int a, int b){
            this.end = a;
            this.weight = b;
        }
        public int compareTo(Pair p){
            return this.weight - p.weight;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        int V = Integer.parseInt(inputs[0]), E = Integer.parseInt(inputs[1]);
        ArrayList<Pair>[] base = new ArrayList[V+1];
        boolean [] visited = new boolean[V+1];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        Deque<Integer> dq = new ArrayDeque<Integer>();
        long answer = 0;
        for(int i = 0 ; i < V+1; i++){
            base[i] = new ArrayList<Pair>();
        }
        for(int i = 0 ; i < E; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]), end= Integer.parseInt(inputs[1]), weight = Integer.parseInt(inputs[2]);
            base[start].add(new Pair(end, weight));
            base[end].add(new Pair(start, weight));
        }
        dq.offer(1);
        while(!dq.isEmpty()){
            int now = dq.poll();
            visited[now] = true;
            for(Pair toGo : base[now]){
                if(!visited[toGo.end]){
                    pq.add(toGo);
                }
            }
            while(!pq.isEmpty()){
                Pair temps = pq.poll();
                if(!visited[temps.end]){
                    visited[temps.end] = true;
                    dq.add(temps.end);
                    answer += temps.weight;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
