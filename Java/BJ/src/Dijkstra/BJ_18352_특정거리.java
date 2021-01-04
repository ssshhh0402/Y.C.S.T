package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class BJ18352_Pair implements Comparable<BJ18352_Pair>{
    int end, weight;

    BJ18352_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
    public int compareTo(BJ18352_Pair b){
        return this.weight - b.weight;
    }
}
public class BJ_18352_특정거리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]), K = Integer.parseInt(inputs[2]), X = Integer.parseInt(inputs[3]);
        PriorityQueue<BJ18352_Pair> pq = new PriorityQueue<BJ18352_Pair>();
        int [] dist = new int[N+1];
        ArrayList[] base = new ArrayList[N+1];
        for(int i=0; i < N+1; i++){
            base[i] = new ArrayList<BJ18352_Pair>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;
        pq.add(new BJ18352_Pair(X,0));

    }
}
