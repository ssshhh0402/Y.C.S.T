package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

class K_Pair implements Comparable<K_Pair>{
    int end, weight;
    K_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }

    public int compareTo(K_Pair k){
        return this.weight - k.weight;
    }
}
public class BJ_1854_K {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int k = Integer.parseInt(inputs[2]);
        PriorityQueue<Integer>[] dist = new PriorityQueue[n+1];
        ArrayList<K_Pair>[] base = new ArrayList[n+1];
        for(int i = 0 ; i < n; i++){
            base[i] = new ArrayList<K_Pair>();
        }
        for(int i = 0; i < m; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);
            base[start].add(new K_Pair(end, weight));
        }
    }
}
