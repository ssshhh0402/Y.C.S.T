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
        C_Pair now = pq.poll();
        int now_x = now.x;
        int now_y = now.y;
        int answer = 0;
        while(!pq.isEmpty()){
            now = pq.poll();
        }

    }
}
