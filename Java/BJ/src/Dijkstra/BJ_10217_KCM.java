package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class A_Pair implements Comparable<A_Pair>{
    int end, weight, cost;

    A_Pair(int a, int b, int c){
        this.end = a;
        this.weight = b;
        this.cost = c;
    }
    public int compareTo(A_Pair a){
        return this.weight - a.weight;
    }
}
public class BJ_10217_KCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T -- > 0){
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]), K = Integer.parseInt(inputs[2]);
            ArrayList<A_Pair>[] base = new ArrayList[N+1];
            int[] dist = new int [N+1];
            PriorityQueue<A_Pair> pq = new PriorityQueue<A_Pair>();
            for(int i = 0 ; i < N+1; i++){
                base[i] = new ArrayList<A_Pair>();
            }
            for(int i = 0 ; i < K; i++){
                inputs = br.readLine().split(" ");
                int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]), cost = Integer.parseInt(inputs[2]), weight = Integer.parseInt(inputs[3]);
                base[start].add(new A_Pair(end, weight, cost));
            }
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[1] = 0;
            long answer = Long.MAX_VALUE;
            pq.add(new A_Pair(1,0,0));                                                  //여기까지 Dijkstra 기본 세팅
            while(!pq.isEmpty()){
                A_Pair now = pq.poll();
                for(A_Pair toGo : base[now.end]){
                    if(dist[toGo.end] > now.weight + toGo.weight && now.cost + toGo.cost <= M){             // 현재까지의 cost + 앞으로 갈곳까지의 cost 가 M 이하인지 확
                        dist[toGo.end] = now.weight + toGo.weight;
                        pq.add(new A_Pair(toGo.end, dist[toGo.end], now.cost + toGo.cost));
                        if(toGo.end == N){                                                                //다음이 N(LA)일 경우 그 경우의 비용을 answer에 저
                            answer = Math.min(answer, now.cost + toGo.cost);
                        }
                    }
                }
            }
            if(answer == Long.MAX_VALUE){
                sb.append("Poor KCM\n");
            }else{
                sb.append(answer + "\n");
            }
//            if(dist[N] == Integer.MAX_VALUE){
//                sb.append("Poor KCM\n");
//            }else {
//                sb.append(answer+"\n");
//            }
        }
        System.out.println(sb.toString());
    }
}
