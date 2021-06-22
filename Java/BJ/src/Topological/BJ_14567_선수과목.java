package Topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_14567_선수과목 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<Integer>();
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        ArrayList<Integer>[] base = new ArrayList[N+1];

        int [] answers = new int[N+1];
        int [] degrees = new int[N+1];
        for(int i = 1; i < N+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i++){
            inputs = br.readLine().split(" ");
            int before = Integer.parseInt(inputs[0]), after = Integer.parseInt(inputs[1]);
            base[before].add(after);
            degrees[after] += 1;
        }
        for(int i = 1; i < N+1; i++){
            if(degrees[i] == 0){
                q.add(i);
                answers[i] = 1;
            }
        }
        while(!q.isEmpty()){
            Integer now = q.poll();
            for(int next : base[now]){
                degrees[next] -= 1;
                if(degrees[next] == 0){
                    answers[next] = answers[now] + 1;
                    q.add(next);
                }
            }
        }
        for(int i = 1; i < N+1; i++){
            sb.append(answers[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
