package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

public class BJ_1922_네트워크 {
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
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean [] used = new boolean[N+1];
        ArrayList<Pair> [] base = new ArrayList[N+1];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        Deque<Integer> dq = new ArrayDeque<Integer>();
        for(int i = 0 ; i < N+1; i++){
            base[i] = new ArrayList<Pair>();
        }
        for(int i = 0; i < M; i++){
            inputs = br.readLine().split(" ");
            int start= Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]), weight = Integer.parseInt(inputs[2]);
            if(start != end){
                base[start].add(new Pair(end, weight));
                base[end].add(new Pair(start, weight));
            }
        }
        long answer = 0;
        used[1] = true;
        dq.offer(1);
        while(!dq.isEmpty()){
            int now = dq.poll();
            for(Pair toGo : base[now]){
                if(!used[toGo.end]){
                    pq.add(toGo);
                }
            }
            while(!pq.isEmpty()){
                Pair temps = pq.poll();
                if(!used[temps.end]){
                    used[temps.end] = true;
                    dq.offer(temps.end);
                    answer += temps.weight;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
