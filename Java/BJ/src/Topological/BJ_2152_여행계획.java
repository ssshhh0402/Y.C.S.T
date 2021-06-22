package Topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2152_여행계획 {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       Queue<Integer> q = new LinkedList<Integer>();
       String[] inputs = br.readLine().split(" ");
       int N = Integer.parseInt(inputs[0]);
       int M = Integer.parseInt(inputs[1]);
       int S = Integer.parseInt(inputs[2]);
       int T = Integer.parseInt(inputs[3]);
       long [] count = new long[N+1];
       ArrayList<Integer>[] base = new ArrayList[N+1];
       for(int i = 1; i < N+1; i++){
           base[i] = new ArrayList<Integer>();
       }
       for(int i = 0; i < M; i++){
           inputs = br.readLine().split(" ");
           int start = Integer.parseInt(inputs[0]);
           int end = Integer.parseInt(inputs[1]);
           base[start].add(end);
       }
       count[S] = 1;
       q.add(S);
       while(!q.isEmpty()){
           Integer now = q.poll();
           for(int toGo : base[now]){
               if(count[toGo] < count[now]){
                   if(count[toGo] == 0){
                       count[toGo] = count[now] + 1;
                   }else{
                       count[toGo] = count[now];
                   }
                   q.add(toGo);
               }
           }
       }
       System.out.println(count[T]);
    }
}
