package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1707_이분그래프 {
    static String [] inputs;
    static int [] used;

    static ArrayList<Integer>[] base;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            inputs = br.readLine().split(" ");
            int V = Integer.parseInt(inputs[0]), E = Integer.parseInt(inputs[1]);
            base = new ArrayList[V+1];
            for(int i = 0 ; i < V+1; i++){
                base[i] = new ArrayList<Integer>();
            }
            used= new int[V+1];
            for(int i = 0 ; i < E; i++){
                inputs = br.readLine().split(" ");
                int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]);
                base[start].add(end);
                base[end].add(start);
            }
            Queue<Integer> q = new LinkedList<Integer>();
            boolean flag = true;
            for(int i = 1; i < V+1; i++){
                if(!flag){
                    break;
                }
                if(used[i] == 0){
                    used[i] = 1;
                    q.offer(i);
                }
                while(!q.isEmpty() && flag){
                    Integer now = q.poll();
                    for(Integer toGo : base[now]){
                        if(used[now] == used[toGo]){
                            sb.append("NO\n");
                            flag = false;
                            break;
                        }
                        if(used[toGo] == 0){
                            q.add(toGo);
                            if(used[now] == 1){
                                used[toGo]= 2;
                            }else if(used[now] == 2){
                                used[toGo] = 1;
                            }
                        }

                    }
                }

            }
            if(flag) {
                sb.append("YES\n");
            }
        }
        System.out.println(sb.toString());
    }
}
