package Topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1516_게임개발 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] times = new int[N+1];
        int [] results = new int[N+1];
        int [] degree = new int[N+1];
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer>[] base = new ArrayList[N+1];
        for(int i = 1 ; i < N+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        String[] inputs;
        for(int i= 1;i < N+1; i++){
            inputs = br.readLine().split(" ");
            int time = Integer.parseInt(inputs[0]);
            times[i] = time;
            for(int j = 1; j < inputs.length-1; j++){
                int before = Integer.parseInt(inputs[j]);
                degree[i] += 1;
                base[before].add(i);
            }
        }
        for(int i = 1; i < N+1; i++){
            if(degree[i] == 0){
                results[i] += times[i];
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int now = q.poll();
            for(Integer toGo : base[now]){
                degree[toGo] -= 1;
                results[toGo] = Math.max(results[toGo], results[now] + times[toGo]);
                if(degree[toGo] == 0){
                    q.add(toGo);
                }
            }
        }
        for(int i = 1; i < N+1; i++){
            sb.append(results[i] + "\n");
        }
        System.out.print(sb.toString());
    }
}
