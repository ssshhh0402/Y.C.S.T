package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class M_Pair{
    int end, weight;

    M_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
}
public class MooTubes {
    static String[] inputs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int Q = Integer.parseInt(inputs[1]);
        ArrayList<M_Pair>[] base = new ArrayList[N+1];
        for(int i = 0 ; i < N+1; i++){
            base[i] = new ArrayList<M_Pair>();
        }
        for(int i = 0 ; i < N-1; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]), weight = Integer.parseInt(inputs[2]);
            base[start].add(new M_Pair(end, weight));
            base[end].add(new M_Pair(start, weight));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < Q; i++){
            inputs = br.readLine().split(" ");
            int K = Integer.parseInt(inputs[0]), start = Integer.parseInt(inputs[1]),count = 0;
            Queue<M_Pair> q = new LinkedList<M_Pair>();
            boolean [] used = new boolean[N+1];
            q.add(new M_Pair(start, 0));
            used[start] = true;
            while(!q.isEmpty()){
                M_Pair now = q.poll();
                for(M_Pair toGo : base[now.end]){
                    if(!used[toGo.end] && toGo.weight >= K){
                        count += 1;
                        used[toGo.end] = true;
                        q.add(toGo);
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb.toString());
    }
}
