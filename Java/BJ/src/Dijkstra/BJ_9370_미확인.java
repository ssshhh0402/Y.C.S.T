package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class U_Pair implements Comparable<U_Pair>{
    int end, weight;

    U_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
    public int compareTo(U_Pair u){
        return this.weight - u.weight;
    }
}
public class BJ_9370_미확인 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String answer=  "";
        while(T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]), t = Integer.parseInt(inputs[2]);
            inputs = br.readLine().split(" ");
            int s = Integer.parseInt(inputs[0]), g = Integer.parseInt(inputs[1]), h = Integer.parseInt(inputs[2]);
            ArrayList<U_Pair>[] base = new ArrayList[n + 1];
            PriorityQueue<U_Pair> pq = new PriorityQueue<U_Pair>();
            int [] dist = new int[n+1];
            int [] answer_temp = new int[t];
            Arrays.fill(dist, Integer.MAX_VALUE);
            for (int i = 0; i < n + 1; i++) {
                base[i] = new ArrayList<U_Pair>();
            }
            for (int i = 0; i < m; i++) {
                inputs = br.readLine().split(" ");
                int start = Integer.parseInt(inputs[0]);
                int end = Integer.parseInt(inputs[1]);
                int weight = Integer.parseInt(inputs[2]);
                if(((start == g) &&(end == h)) || ((start == h) && (end == g))){
                    base[start].add(new U_Pair(end, 2 * weight - 1));
                    base[end].add(new U_Pair(start, 2 * weight - 1));
                }else{
                    base[start].add(new U_Pair(end, 2 * weight));
                    base[end].add(new U_Pair(start, 2 * weight));
                }
            }
            for(int i = 0; i < t; i++){
                answer_temp[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(answer_temp);
            pq.add(new U_Pair(s, 0));
            dist[s] = 0;
            while(!pq.isEmpty()){
                U_Pair now = pq.poll();
                for(U_Pair toGo : base[now.end]){
                    if(dist[toGo.end] > dist[now.end] + toGo.weight){
                        dist[toGo.end] = dist[now.end] + toGo.weight;
                        pq.add(new U_Pair(toGo.end, dist[toGo.end]));
                    }
                }
            }
            for(int item : answer_temp){
                if(dist[item] != Integer.MAX_VALUE && dist[item] % 2 != 0){
                    answer += item + " ";
                }
            }
            answer += ("\n");
        }
        System.out.println(answer);
    }
}
