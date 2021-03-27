package Goorm.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro3 {
   static ArrayList<Integer>[] base;
   static Queue<Integer> q;
   static int N;
   public static boolean find(int start, int end){
       q = new LinkedList<Integer>();
       int [] dist = new int[N+1];
       Arrays.fill(dist, Integer.MAX_VALUE);
       q.add(start);
       dist[start] = 0;
       while(!q.isEmpty()){
           int now = q.poll();
           if(now == end){
               break;
           }
           for(Integer toGo : base[now]){
               if(dist[toGo] > dist[now] + 1){
                   dist[toGo] = dist[now] + 1;
                   q.add(toGo);
               }
           }
       }
       if(dist[end] == Integer.MAX_VALUE){
           return false;
       }
       else{
           return true;
       }
   }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = br.readLine().split( " ");
        N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        base = new ArrayList[N+1];
        for(int i =1; i < N+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < N-1; i++){
            inputs = br.readLine().split(" ");
            int start =Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);                                      //start가 end 상위 제
            base[start].add(end);
        }
        for(int i = 0; i < M; i++){
            inputs = br.readLine().split(" ");
            int start= Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);                                          //start 가 End의 상위제품?
            if(find(start, end)){
                sb.append("yes" + "\n");
            }else{
                sb.append("no" + "\n");
            }

        }
        System.out.println(sb.toString());
    }

}
