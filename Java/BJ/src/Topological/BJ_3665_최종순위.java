package Topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_3665_최종순위 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q;
        int T = Integer.parseInt(br.readLine());
        int N, answer;
        int [] degree, last, present;
        int [][] base;
        String [] inputs;
        while(T -- > 0){
            N = Integer.parseInt(br.readLine());
            degree = new int[N+1];
            base = new int[N+1][N+1];
            last = new int[N];
            present = new int[N];
            answer = 0;
            q = new LinkedList<Integer>();
            inputs = br.readLine().split(" ");
            for(int i = 0 ; i < N; i++){
                last[i] = Integer.parseInt(inputs[i]);
            }
            for(int x = 0; x < N; x++){
                for(int y = x+1; y < N; y++){
                    base[last[x]][last[y]] = 1;
                    degree[last[y]] += 1;
                }
            }
            int M = Integer.parseInt(br.readLine());
            for(int i = 0; i < M; i++){
                inputs = br.readLine().split(" ");
                int left = Integer.parseInt(inputs[0]), right = Integer.parseInt(inputs[1]);
                if(base[left][right] == 1){
                    base[right][left] = 1;
                    base[left][right] = 0;
                    degree[left] += 1;
                    degree[right] -= 1;
                }else{
                    base[right][left] = 0;
                    base[left][right] = 1;
                    degree[left] -= 1;
                    degree[right] += 1;
                }
            }
            for(int i = 1; i < N+1; i++){
                if(degree[i] == 0){
                    q.add(i);
                }
            }

            for(int i = 0; i < N; i++){
                if(q.isEmpty()){
                    answer = 1;
                    break;
                }else if(q.size() > 1){
                    answer = -1;
                    break;
                }
                int now = q.poll();
                present[i] = now;
                for(int toGo = 1; toGo < N+1; toGo++){
                    if(base[now][toGo] == 1){
                        degree[toGo] -= 1;
                        if(degree[toGo] == 0){
                            q.offer(toGo);
                        }
                    }
                }
            }
            if(answer == -1){
                sb.append("?\n");
            }else if(answer == 1){
                sb.append("IMPOSSIBLE\n");
            }else{
                for(int item : present){
                    sb.append(item + " ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());

    }
}
