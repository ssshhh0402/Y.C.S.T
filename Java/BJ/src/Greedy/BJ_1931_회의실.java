package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1931_회의실 {
    static class time implements Comparable<time>{
        int start , end;

        time(int a, int b){
            this.start = a;
            this.end = b;
        }

        public int compareTo(time t){
            if(this.end == t.end){
                return this.start - t.start;
            }else{
                return this.end - t.end;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<time> pq = new PriorityQueue<time>();
        int N = Integer.parseInt(br.readLine());
        String [] inputs;
        for(int i = 0 ;i < N; i++){
            inputs = br.readLine().split(" ");
            pq.add(new time(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
        }
        int answer = 0;
        int flag = Integer.MIN_VALUE;
        for(int i = 0 ; i < N; i++){
            time t = pq.poll();
            if(t.start >= flag){
                flag = t.end;
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
