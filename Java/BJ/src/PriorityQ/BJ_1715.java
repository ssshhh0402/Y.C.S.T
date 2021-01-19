package PriorityQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());

        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for(long i = 0; i < N; i++){
            pq.add(Long.parseLong(br.readLine()));
        }
        if (N == 1){
            System.out.println(0);
            return;
        }
        while(!pq.isEmpty()){
            long one = pq.poll();
            long two = pq.poll();
            long three = one + two;
            answer += three;
            if(!pq.isEmpty()){
                pq.add(three);
            }
        }
        System.out.println(answer);
    }
}
