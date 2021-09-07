package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ_1826_연료채우기 {
    static class Station implements Comparable<Station>{
        int dist, fuel;

        Station(int a, int b){
            this.dist = a;
            this.fuel = b;
        }

        public int compareTo(Station s){
            return s.fuel - this.fuel;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Station> pq = new PriorityQueue<Station>();
        int N = Integer.parseInt(br.readLine());
        String[] inputs;
        for(int i = 0 ; i < N; i++){
            inputs = br.readLine().split(" ");
            int dist = Integer.parseInt(inputs[0]), fuel = Integer.parseInt(inputs[1]);
            pq.add(new Station(dist, fuel));
        }
        inputs = br.readLine().split(" ");
        int L = Integer.parseInt(inputs[0]), P = Integer.parseInt(inputs[1]);
        if(L < P){
            System.out.println(1);
        }else{
            boolean flag = false;
            int count = 0;
            int current = 0;
            while(true){
                if(current + P > L){
                   flag = true;
                   break;
                }
                Station next = pq.poll();
                if(next.dist < current){
                    continue;
                }
                if(current + P < next.dist){
                    pq.offer(next);
                    continue;
                }
                count += 1;
                P = P - (next.dist - current) + next.fuel;
                current = next.dist;
            }
            if(!flag){
                System.out.println(1);
            }else{
                System.out.println(count);
            }
        }

    }
}
