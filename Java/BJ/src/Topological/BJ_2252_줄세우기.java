package Topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2252_줄세우기 {
    static ArrayList<Integer>[] base;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        base = new ArrayList[N+1];
        Queue<Integer> q = new LinkedList<Integer>();
        int [] count = new int[N+1];
        for(int i = 0; i < N+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            base[start].add(end);
            count[end] += 1;
        }
        for(int i = 1; i < N+1; i++){
            if(count[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now + " ");
            for(int toGo : base[now]){
                count[toGo] -= 1;
                if(count[toGo] == 0){
                    q.add(toGo);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
