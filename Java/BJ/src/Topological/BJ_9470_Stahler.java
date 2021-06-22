package Topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_9470_Stahler {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer>[]base;
        String [] inputs;
        while(T -- > 0){
            inputs=  br.readLine().split(" ");
            Queue<Integer> q = new LinkedList<Integer>();
            int K = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]), P = Integer.parseInt(inputs[2]);
            base = new ArrayList[M+1];
            for(int i = 1 ; i < M+1; i++){
                base[i] = new ArrayList<Integer>();
            }
            int [] degrees = new int[M+1];
            int [] stahlers = new int[M+1];
            int [] count = new int[M+1];
            for(int i = 0 ; i < P; i++){
                inputs = br.readLine().split(" ");
                int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]);
                degrees[end] += 1;
                base[start].add(end);
            }
            for(int i = 1 ; i < M+1; i++){
                if(degrees[i] == 0){
                    q.offer(i);
                    stahlers[i] = 1;
                }
            }
            while(!q.isEmpty()){
                Integer now = q.poll();
                for(int toGo : base[now]){
                    if(stahlers[toGo] < stahlers[now]){
                        stahlers[toGo] = stahlers[now];
                        count[toGo] = 1;
                    }else if(stahlers[toGo] == stahlers[now]){
                        count[toGo] += 1;
                    }
                    degrees[toGo] -= 1;
                    if(degrees[toGo] == 0){
                        q.add(toGo);
                        if(count[toGo] >= 2){
                            stahlers[toGo] += 1;
                        }
                    }
                }
            }
            sb.append(K).append(" ").append(stahlers[M]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
