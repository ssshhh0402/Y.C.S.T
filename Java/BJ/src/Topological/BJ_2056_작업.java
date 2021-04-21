package Topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2056_작업 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<Integer>();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] base = new ArrayList[N+1];
        int [] times = new int[N+1];
        int [] result = new int[N+1];
        int [] degree = new int[N+1];
        String[] inputs;
        int answer = 0;
        for(int i = 1; i < N+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i < N+1; i++){
            inputs = br.readLine().split(" ");
            times[i] = Integer.parseInt(inputs[0]);
            int n = Integer.parseInt(inputs[1]);
            for(int j = 0; j < n; j++){
                base[Integer.parseInt(inputs[2+j])].add(i);
            }
            degree[i] += n;
        }
        for(int i = 1 ; i < N+1; i++){
            result[i] = times[i];
            if(degree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int now = q.poll();
            for(int toGo : base[now]){
                result[toGo] = Math.max(result[toGo], result[now] + times[toGo]);
                degree[toGo] -= 1;
                if(degree[toGo] == 0){
                    q.add(toGo);
                }
            }
        }
        for(int i = 1; i < N+1; i++){
            answer = Math.max(answer, result[i]);
        }
        System.out.println(answer);
    }
}
