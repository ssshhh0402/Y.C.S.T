package Devmat_Back_Late_Real;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Pro2 {
    static class Cook implements Comparable<Cook>{
        int start, end;

        Cook(int a, int b){
            this.start = a;
            this.end = b;
        }
        public int compareTo(Cook c){
            return this.end - c.end;
        }
    }
    public static int solution(int n,String[] recipes, String[] orders){
        Map<String, Integer> m = new LinkedHashMap<String, Integer>();
        PriorityQueue<Cook> pq = new PriorityQueue<Cook>();
        int answer=  0;
        for(String recipe : recipes){
            String [] info = recipe.split(" ");
            m.put(info[0], Integer.parseInt(info[1]));
        }
        for(int i = 0; i < orders.length; i++) {
            String[] order = orders[i].split(" ");
            String menu = order[0];
            int time = Integer.parseInt(order[1]);
            if (i == orders.length - 1) {
                if(pq.size() == n){
                    Cook c = pq.poll();
                    if(c.end <= time){
                       answer = time+m.get(menu);
                    }else{
                        answer = c.end + m.get(menu);
                    }
                }else{
                    answer = time+m.get(menu);
                }
            } else {
                if (pq.size() == n) {
                    Cook c = pq.poll();
                    if (c.end <= time) {
                        pq.add(new Cook(time, time + m.get(menu)));
                    } else {
                        pq.add(new Cook(c.end, c.end + m.get(menu)));
                    }
                } else {
                    pq.add(new Cook(time, time + m.get(menu)));
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int n = 2;
        String [] recipes = new String [] {"A 3", "B 2"};
        String [] orders = new String [] {"A 1","A 2","B 3","B 4"};
        System.out.println(solution(n,recipes, orders));
    }
}
