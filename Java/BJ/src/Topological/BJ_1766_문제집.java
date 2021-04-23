package Topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BJ_1766_문제집 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        int [] degree = new int[N+1];
        ArrayList<Integer>[] base = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]);
            degree[end] += 1;
            base[start].add(end);
        }
        for(int i = 1 ; i < N+1; i++){
            if(degree[i] == 0){
                pq.add(i);
            }
        }
        while(!pq.isEmpty()){
            Integer now = pq.poll();
            sb.append(now + " ");
            for(int toGo : base[now]){
                degree[toGo] -= 1;
                if(degree[toGo] == 0){
                    pq.add(toGo);
                }
            }
        }
        System.out.print(sb.toString());
    }
}
