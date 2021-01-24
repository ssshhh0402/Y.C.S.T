package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1389_케빈베이컨 {
    static String[] inputs;
    static ArrayList<Integer>[] base;
    public static int find(int start, int end){
        int count = 0;
        boolean [] used = new boolean[base.length+1];
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {start,0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == end){
                return now[1];
            }
            for(int toGo : base[now[0]]){
                if(!used[toGo]){
                    used[toGo] = true;
                    count += 1;
                    q.offer(new int[]{toGo,now[1]+1});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        int answer = 0;
        int temps = Integer.MAX_VALUE;
        base = new ArrayList[N+1];
        for(int i = 0 ; i < N+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]);
            base[a].add(b);
            base[b].add(a);
        }
        for(int i = 1; i < N+1; i++){
            int count = 0;
            for(int j = 1; j < N+1; j++){
                if(i!= j){
                    int a = find(i,j);
                    if(a != -1){
                        count += a;
                    }
                }
            }
            if(count < temps){
                temps = count;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
