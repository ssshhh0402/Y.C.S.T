package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_11725_트리부모찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<Integer>();
        int n = Integer.parseInt(br.readLine());
        int [] parents = new int[n+1];
        boolean [] used = new boolean[n+1];
        ArrayList<Integer>[] base = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        String[] inputs;
        for(int i = 0; i < n-1; i++){
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]);
            base[a].add(b);
            base[b].add(a);
        }
        q.offer(1);
        used[1] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int toGo : base[now]){
                if(!used[toGo]) {
                    used[toGo] = true;
                    parents[toGo] = now;
                    q.offer(toGo);
                }
            }
        }
        for(int i = 2; i < n+1; i++){
            sb.append(parents[i]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
