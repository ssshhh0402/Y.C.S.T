package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_10814_나이순정렬 {
    static class Person implements Comparable<Person>{
        int age, idx;
        String name;
        Person(int a, int b, String c){
            this.age = a;
            this.idx = b;
            this.name = c;
        }
        public int compareTo(Person p){
            if(this.age == p.age){
                return this.idx - p.idx;
            }else{
                return this.age - p.age;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Person> pq = new PriorityQueue<Person>();
        String [] inputs;
        for(int i = 0; i < N; i++){
            inputs = br.readLine().split(" ");
            int age = Integer.parseInt(inputs[0]);
            pq.add(new Person(age, i, inputs[1]));
        }
        while(!pq.isEmpty()){
            Person now = pq.poll();
            sb.append(now.age + " " + now.name + "\n");
        }
        System.out.println(sb.toString());
    }
}
