package Monthly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Pro4 {
    static ArrayList<Pair>[] base;
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
    public static long find(long target, int [][] roads, int n, int z){
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(0,0));
        boolean find = false;

        long answer = 0;
        while(!pq.isEmpty()){
            int N = pq.size();
            boolean flag = false;
            for(int i = 0; i < N; i++) {
                Pair now = pq.poll();
                if (now.weight > target) {
                    continue;
                }else if(now.weight == target){
                    flag = true;
                    break;
                }
                for(Pair toGo : base[now.end]){
                    Pair newOne = new Pair(toGo.end, now.weight + toGo.weight);


                }
                for(int j = 0; j < n; j++){
                    if(j != now.end){
                        Pair newOne = new Pair(j, now.weight);

                    }
                }
                Pair newOne = new Pair(now.end, now.weight + z);
                if(!base[now.end].contains(newOne)){
                    base[now.end].add(newOne);
                    pq.add(newOne);
                }
            }
            if(flag){
                find = true;
                break;
            }else {
                answer += 1;
            }
        }
        if(find){
            return answer;
        }else{
            return -1;
        }
    }
    public static long[] solution(int n, int z, int [][] roads, long[] queries){
        base = new ArrayList[n+1];
        long [] answer = new long[queries.length];
        for(int i =0; i < n; i++){
            base[i] = new ArrayList<Pair>();
        }
        for(int [] road : roads){
            base[road[0]].add(new Pair(road[1], road[2]));
        }
        for(int i = 0 ; i < queries.length; i++){
            answer[i] = find(queries[i],roads,n,z);
        }

        return answer;
    }
    public static void main(String[] args) {
        long [] answers = solution(5, 5, new int [][] {{1,2,3},{0,3,2}}, new long [] {0,1,2,3,4,5,6});
        for(long answer : answers){
            System.out.println(answer);
        }
    }
}
