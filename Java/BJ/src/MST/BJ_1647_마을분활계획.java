package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1647_마을분활계획 {
    static String[] inputs;
    static int[] parents;
    static class Pair implements Comparable<Pair>{
        int start, end,weight;

        Pair(int a, int b, int c){
            this.start = a;
            this.end = b;
            this.weight = c;
        }

        public int compareTo(Pair p){
            return this.weight - p.weight;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        parents = new int[N+1];
        for(int i = 0 ;i < N+1; i++){
            parents[i] = i;
        }
        for(int i = 0 ; i < M;i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]), weight = Integer.parseInt(inputs[2]);
            pq.add(new Pair(start, end, weight));
        }
        int answer = 0;
        int size = 0;
        while(size < N-2){
            Pair now = pq.poll();
            if(!isSame(now.start, now.end)){
                union(now.start, now.end);
                answer += now.weight;
                size += 1;
            }
        }
        System.out.println(answer);
    }
    public static boolean isSame(int a, int b){
        if(find(a) == find(b)){
            return true;
        }else{
            return false;
        }
    }
    public static int find(int a){
        if(a == parents[a]){
            return a;
        }else{
            return parents[a] = find(parents[a]);
        }
    }
    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x == y){
            return;
        }
        if(x > y){
            parents[y]= x;
        }else{
            parents[x] = y;
        }
    }
}
