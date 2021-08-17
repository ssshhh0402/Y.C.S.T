package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_11047_동전0 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), K = Integer.parseInt(inputs[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        while(pq.size() < N){
            pq.add(Integer.parseInt(br.readLine()));
        }
        long answer = 0;
        while(!pq.isEmpty() && K != 0){
            int now = pq.poll();
            if(now <= K){
                answer += K / now;
                K %= now;
            }
        }
        System.out.println(answer);
    }
}
