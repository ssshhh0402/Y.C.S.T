package Topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2623_음악프로그램 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<Integer>();
        String[] inputs = br.readLine().split(" ");
        ArrayList<Integer> answers = new ArrayList<Integer>();
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        int [] degree = new int[N+1];
        ArrayList<Integer>[] base = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i++){
            inputs = br.readLine().split(" ");
            for(int j = 2; j < inputs.length; j++){
                int now = Integer.parseInt(inputs[j]);
                int before = Integer.parseInt(inputs[j-1]);
                degree[now] += 1;
                base[before].add(now);
            }

        }
        for(int i = 1; i < N+1; i++){
            if(degree[i] == 0){
                answers.add(i);
                q.add(i);
            }
        }
        if(q.size() == 0){
            System.out.println(0);
        }else{
            while(!q.isEmpty()){
                int now = q.poll();
                for(Integer toGo : base[now]){
                    degree[toGo] -= 1;
                    if(degree[toGo] == 0){
                        answers.add(toGo);
                        q.add(toGo);
                    }
                }
            }
        }
        if(answers.size() == N) {
            for(int answer : answers){
                sb.append(answer + "\n");
            }
            System.out.println(sb.toString());
        }else{
            System.out.println(0);
        }
    }
}
