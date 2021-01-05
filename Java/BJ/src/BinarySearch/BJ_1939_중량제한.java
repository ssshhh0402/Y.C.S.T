package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int weight;
    int end;

    Pair(int end, int weight){
        this.end= end;
        this.weight = weight;
    }
}
public class BJ_1939_중량제한 {
    static String[] inputs;
    static int N, M, S,E;
    static ArrayList<Pair>[] base;
    static Queue<Integer> q ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        base = new ArrayList[N+1];
        int left = 1;
        int right = 0;
        for(int i = 0; i < N+1; i++){
            base[i] = new ArrayList<Pair>();
        }
        for(int i = 0; i < M; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);
            base[start].add(new Pair(end, weight));
            base[end].add(new Pair(start, weight));
            right = Math.max(right, weight);
        }
        int answer =0;
        inputs = br.readLine().split(" ");
        S = Integer.parseInt(inputs[0]);
        E = Integer.parseInt(inputs[1]);
        while(left <= right){
            boolean flag = false;
            q = new LinkedList<Integer>();
            int mid = (left + right) / 2;
            boolean[] visited = new boolean[N+1];
            visited[S] = true;
            q.offer(S);
            while(!q.isEmpty()){
                int now = q.poll();
                if(now == E){
                    flag = true;
                    break;
                }
                for(Pair toGo : base[now]){
                    if(toGo.weight >= mid && ! visited[toGo.end]){
                        visited[toGo.end] = true;
                        q.add(toGo.end);
                    }
                }
            }
            if(flag){
                left = mid + 1;
                answer = Math.max(answer ,mid);
            }else{
                right = mid - 1;
            }
        }
        System.out.println(right);

    }
}
