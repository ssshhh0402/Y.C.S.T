package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_11724_연결요소갯수 {
    static String[] inputs;
    static ArrayList<Integer>[] base;
    static boolean[] visited;
    public static void dfs(int start){
        visited[start]= true;
        for(int toGo : base[start]){
            if(!visited[toGo]){
                dfs(toGo);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        base = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 0 ;i < N+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            base[start].add(end);
            base[end].add(start);
        }
        int answer = 0;
        for(int i= 1; i < N+1; i++){
            if(!visited[i]){
                dfs(i);
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
