package Sweeping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class C_Pair implements Comparable<C_Pair>{
    int x, y;

    C_Pair(int a, int b){
        this.x = a;
        this.y = b;
    }
    public int compareTo(C_Pair c){
        if(this.x == c.x){
            return this.y - c.y;
        }else{
            return this.x - c.x;
        }
    }
}
public class BJ_2261_가장가까운두점 {
    public static int find(C_Pair a, C_Pair b){
        int a_x = Math.abs(a.x);
        int a_y = Math.abs(a.y);
        int b_x = Math.abs(b.x);
        int b_y = Math.abs(b.y);
        return (b_x - a_x) * (b_x - a_x) + (b_y - a_y) * (b_y - a_y);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = {};
        PriorityQueue<C_Pair> pq = new PriorityQueue<C_Pair>();
        for(int i = 0 ; i < N; i++){
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            pq.add(new C_Pair(x,y));
        }
        C_Pair base = pq.poll();
        int answer = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            C_Pair now = pq.poll();
            int dist = find(base, now);
            if(dist < answer){
                answer = dist;
            }
            base = now;
        }
        System.out.println(answer);

    }
}
