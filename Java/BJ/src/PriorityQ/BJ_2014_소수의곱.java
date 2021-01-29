package PriorityQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_2014_소수의곱 {
    static String[] inputs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        int K = Integer.parseInt(inputs[0]), N = Integer.parseInt(inputs[1]);
        Long [] base = new Long[K];
        inputs = br.readLine().split(" ");
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for(int i = 0 ; i < K; i++){
            base[i] = Long.parseLong(inputs[i]);
            pq.add(base[i]);
        }
        while(N -- > 0){
            answer = pq.poll();
            for(int i = 0 ; i < K; i++){
                if(answer * base[i] >= ((long) 2 << 30)){
                    break;
                }
                long n = answer * base[i];
                if(!pq.contains(n)){
                    pq.add(n);
                }
            }
        }
        System.out.println(answer);
    }
}
