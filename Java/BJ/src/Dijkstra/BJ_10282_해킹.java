package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

class H_Pair{
    int end, weight;

    H_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
}
public class BJ_10282_해킹 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String answer = "";
        while(T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int d = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);
            PriorityQueue<H_Pair> pq = new PriorityQueue<H_Pair>();
            ArrayList<H_Pair>[] base = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                base[i] = new ArrayList<H_Pair>();
            }
            for (int i = 0; i < d; i++) {
                inputs = br.readLine().split(" ");
                int start = Integer.parseInt(inputs[0]);
                int end = Integer.parseInt(inputs[1]);
                int weight = Integer.parseInt(inputs[2]);
                base[end].add(new H_Pair(start, weight));
            }
            boolean[] used = new boolean[n + 1];
            q.add(new H_Pair(c,0));
            int weights = 0;
            int count = 0;
            used[c] = true;
            while (!q.isEmpty()) {
                int now = q.poll();
                count += 1;
                for (H_Pair toGo : base[now]) {
                    if (!used[toGo.end]) {
                        used[toGo.end] = true;
                        weights += toGo.weight;
                        q.add(toGo.end);
                    }
                }
            }
            answer += count + " " + weights + "\n";
        }
        System.out.println(answer);
    }
}
