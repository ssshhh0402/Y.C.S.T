package Topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1005_ACM {
    static class Pair{
        int end, weight;
        Pair(int a, int b){
            this.end = a;
            this.weight = b;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N, M, answer;
        ArrayList<Integer>[] base;
        int [] count, times;
        Queue<Pair> q;
        String[] inputs;

        while(T -- > 0){
            answer = Integer.MIN_VALUE;
            inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);
            M = Integer.parseInt(inputs[1]);
            base = new ArrayList[N+1];
            count = new int[N+1];
            times = new int[N+1];
            q = new LinkedList<Pair>();
            for(int i = 1; i < N+1; i++){
                base[i] = new ArrayList<Integer>();
            }
            inputs = br.readLine().split(" ");
            for(int i = 0; i < N; i++){
                times[i+1] = Integer.parseInt(inputs[i]);
            }
            for(int i = 0 ; i < M; i++){
                inputs = br.readLine().split(" ");
                int start = Integer.parseInt(inputs[0]);
                int end = Integer.parseInt(inputs[1]);
                base[start].add(end);
                count[end] += 1;
            }
            int W = Integer.parseInt(br.readLine());
            for(int i = 1; i < N+1; i++){
                if(count[i] == 0){
                    q.add(new Pair(i, times[i]));
                }
            }
            while(!q.isEmpty()){
                Pair now = q.poll();
                if(now.end == W){
                    answer = Math.max(now.weight, answer);
                    continue;
                }
                for(int toGo : base[now.end]){
                    count[toGo] -= 1;
                    if(count[toGo] == 0){
                        q.add(new Pair(toGo, now.weight + times[toGo]));
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
