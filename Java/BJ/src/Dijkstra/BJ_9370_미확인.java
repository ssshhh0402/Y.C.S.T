package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        while(T-- >= 0) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int t = Integer.parseInt(inputs[2]);
            inputs = br.readLine().split(" ");
            int s = Integer.parseInt(inputs[0]);
            int g = Integer.parseInt(inputs[1]);
            int h = Integer.parseInt(inputs[2]);
            ArrayList<U_Pair>[] base = new ArrayList[n + 1];
            PriorityQueue<U_Pair> pq = new PriorityQueue<U_Pair>();
            for (int i = 0; i < n + 1; i++) {
                base[i] = new ArrayList<U_Pair>();
            }
            for (int i = 0; i < m; i++) {
                inputs = br.readLine().split(" ");
                int start = Integer.parseInt(inputs[0]);
                int end = Integer.parseInt(inputs[1]);
                int weight = Integer.parseInt(inputs[2]);
                base[start].add(new U_Pair(end, weight));
            }
        }
    }
}
