package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_13023_ABCDE {
    static ArrayList<Integer>[] base;
    static int count = 0;
    static boolean [] used, counts;
    public static void dfs(int start, int now){
        if(start + 1 == now){
            counts[start] = true;
            count += 1;
        }else{
            for(int toGo : base[now]){
                if(counts[start]){
                    break;
                } else if(!used[toGo]) {
                    used[toGo] = true;
                    dfs(start, toGo);
                    used[toGo] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        base = new ArrayList[N];
        used = new boolean[N];
        counts = new boolean[N];
        for(int i = 0; i < N; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            base[start].add(end);
            base[end].add(start);
        }
        for(int i = 0 ;i < N; i++){
            used[i] = true;
            dfs(i,i);
            used[i] = false;
        }
        if(count == N-1){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
