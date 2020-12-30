package Sweeping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class S_Pair implements Comparable<S_Pair>{
    int start, end;
    S_Pair(int a, int b){
        this.start = a;
        this.end = b;
    }
    public int compareTo(S_Pair s){
        if(this.start == s.start){
            return this.end - s.end;
        }else{
            return this.start - s.start;
        }
    }
}
public class BJ_2170_선긋기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<S_Pair> pq = new PriorityQueue<S_Pair>();
        String[] inputs = {};
        for(int i=0; i < N; i++){
            inputs = br.readLine().split(" ");
            int s = Integer.parseInt(inputs[0]);
            int e = Integer.parseInt(inputs[1]);
            if(s > e){
                pq.add(new S_Pair(e, s));
            }else if(e > s){
                pq.add(new S_Pair(s,e));
            }
        }
        S_Pair now = pq.poll();
        int now_s = now.start;
        int now_e = now.end;
        int count = now_e - now_s;
        while(!pq.isEmpty()){
            now = pq.poll();
            if(now.start > now_e){
                count += (now.end - now.start);
                now_s = now.start;
                now_e = now.end;
            }else{
                if(now.end > now_e){
                    count += (now.end - now_e);
                    now_e = now.end;
                }
            }
        }
        System.out.println(count);
    }
}
