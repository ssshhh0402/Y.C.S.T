package KaKaoCommerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro3 {
    static int N;
    static ArrayList<Integer> [] base;
    static class Pair{
        int end, people;
        Pair(int a, int b){
            this.end = a;
            this.people = b;
        }
    }
    public static int[] dijk (int [] passenger){
        Queue<Pair> q = new LinkedList<Pair>();
        int [] dist = new int[passenger.length+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        q.add(new Pair(1, passenger[0]));
        while(!q.isEmpty()){
            Pair now = q.poll();
            for(int toGo : base[now.end]){
                if(dist[toGo] > now.people + passenger[toGo-1]){
                    dist[toGo] = now.people + passenger[toGo-1];
                    q.add(new Pair(toGo, dist[toGo]));
                }
            }
        }
        return dist;
    }
    public static int[] solution(int n, int [] passenger, int [][] train){
        base = new ArrayList[n+1];
        int [] answer = {0,0};
        for(int x = 1; x < n+1; x++){
            base[x] = new ArrayList<Integer>();
        }
        for(int [] info : train){
            base[info[0]].add(info[1]);
        }
        int [] dists = dijk(passenger);
        for(int i = 1 ; i < n+1; i++){
            if(dists[i] != Integer.MAX_VALUE && dists[i] >= answer[1]){
                answer[0] = i;
                answer[1] = dists[i];
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] answers = solution(6,new int [] {1,1,1,1,1,1},new int [][] {{1,2},{1,3},{3,5},{3,6}});
        for(int answer : answers){
            System.out.println(answer);
        }

    }
}
