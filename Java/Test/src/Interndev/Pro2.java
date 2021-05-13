package Interndev;

import java.util.PriorityQueue;

public class Pro2 {
    public static class Item implements Comparable<Item>{
        int time, ticket, idx;

        Item(int a, int b, int c){
            this.time = a;
            this.ticket = b;
            this.idx = c;
        }
        public int compareTo(Item i){
            if(this.ticket != i.ticket){
                return this.ticket - i.ticket;
            }else{
                if(this.time != i.time){
                    return this.time - i.time;
                }else{
                    return this.idx - i.idx;
                }
            }
        }
    }
    public static int [] solution(int [] t, int [] r){
        int [] answer = new int[t.length];
        PriorityQueue<Item> pq = new PriorityQueue<Item>();
        int count = 0;
        int a_count = 0;
        int max = 0;
        for(int T : t){
            max = Math.max(T, max);
        }
        while(count <= max && a_count <= max){
            if(count <= max) {
                for (int i = 0; i < t.length; i++) {
                    if (t[i] == count) {
                        pq.add(new Item(count, r[i], i));
                    }
                }

            }
            if(!pq.isEmpty()){
                Item person = pq.poll();
                answer[a_count] = person.idx;
                a_count += 1;
            }
            count += 1;
        }
        return answer;
    }
    public static void main(String [] args){
        int []results = solution(new int [] {0,1,3,0},new int [] {0,1,2,3});
        for(int result : results){
            System.out.println(result);
        }
        results= solution(new int [] {7,6,8,1}, new int [] {0,1,2,3});
        for(int result : results){
            System.out.println(result);
        }
    }
}
