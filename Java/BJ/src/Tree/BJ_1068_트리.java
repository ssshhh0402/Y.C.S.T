package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1068_트리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<Integer>();
        boolean [] used = new boolean[n];
        ArrayList<Integer>[] base = new ArrayList[n];
        int answer = 0, start = 0;
        for(int i = 0 ; i < n; i++){
            base[i] = new ArrayList<Integer>();
        }
        String[] inputs = br.readLine().split(" ");
        for(int i = 0 ; i < n; i++){
            int now = Integer.parseInt(inputs[i]);
            if(now == -1){
                start = i;
            }else{
                base[now].add(i);
            }
        }
        int broken = Integer.parseInt(br.readLine());
        if(broken != start){
            q.offer(start);
            used[start] = true;
            used[broken] = true;
        }
        while(!q.isEmpty()){
            int now = q.poll();
            if(base[now].size() == 0){
                answer += 1;
                continue;
            }
            for(int toGo : base[now]){
                if(toGo != broken) {
                    if (!used[toGo]) {
                        used[toGo] = true;
                        q.add(toGo);
                    }
                }else{
                    if(base[now].size() == 1){
                        answer += 1;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
