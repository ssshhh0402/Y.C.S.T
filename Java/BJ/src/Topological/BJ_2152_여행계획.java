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
       String[] inputs = br.readLine().split(" ");
       Queue<Integer> q = new LinkedList<Integer>();
       int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]), S = Integer.parseInt(inputs[2]), T = Integer.parseInt(inputs[3]);
       int[] degree = new int[N+1];
       int [][] dp = new int [N+1][N+1];
       ArrayList<Integer>[] base = new ArrayList[N+1];
       for(int i = 1; i < N+1; i++){
           base[i] = new ArrayList<Integer>();
       }
       for(int i = 0; i < M; i++){
           inputs = br.readLine().split(" ");
           int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]);
           base[start].add(end);
           degree[end] += 1;
       }
       q.add(S);
       while(!q.isEmpty()){
           Integer now = q.poll();

       }
    }
}
