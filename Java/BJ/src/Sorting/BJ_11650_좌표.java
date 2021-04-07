package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_11650_좌표 {
    static class Pair implements Comparable<Pair>{
        int x, y;

        Pair(int a, int b){
            this.x = a;
            this.y = b;
        }
        public int compareTo(Pair p){
            if(this.x == p.x){
                return this.y - p.y;
            }else{
                return this.x - p.x;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String [] inputs;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for(int i = 0 ; i < N; i++){
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]), y = Integer.parseInt(inputs[1]);
            pq.add(new Pair(x, y));
        }
        while(!pq.isEmpty()){
            Pair now = pq.poll();
            sb.append(now.x + " " + now.y + "\n");
        }
        System.out.println(sb.toString());

    }
}
