package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1946_신입사원 {
    static class Person implements Comparable<Person>{
        int s, m;

        Person(int a, int b){
            this.s = a;
            this.m = b;
        }

        public int compareTo(Person p){
            return this.s - p.s;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            PriorityQueue<Person> pq = new PriorityQueue<Person>();
            int N = Integer.parseInt(br.readLine());
            String [] inputs;
            for(int i = 0 ; i < N; i++){
                inputs = br.readLine().split(" ");
                int s = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);
                pq.add(new Person(s,m));
            }
            int answer = 0;
            int min = Integer.MAX_VALUE;
            while(!pq.isEmpty()){
                Person now = pq.poll();
                if(now.m <= min){
                    answer += 1;
                    min = now.m;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
}
