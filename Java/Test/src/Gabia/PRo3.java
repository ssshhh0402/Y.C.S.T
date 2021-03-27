package Gabia;

import java.util.LinkedList;
import java.util.Queue;

public class PRo3 {
    static class Pair{
        int idx, time;

        Pair(int a, int b){
            this.idx = a;
            this.time = b;
        }

    }
    public static int get_time(Queue<Pair> machines){
        int target = Integer.MAX_VALUE;
        for(Pair now : machines){
            if(now.time < target){
                target = now.time;
            }
        }
        return target;
    }
    public static int [] solution(int N, int [] coffee_times) {
        int M = coffee_times.length;
        int[] answer = new int[M];
        Queue<Pair> machine = new LinkedList<Pair>();
        int finished = 0;
        int making = 0;
        int target = Integer.MAX_VALUE;
        while (finished != M) {
            while (machine.size() != N && making != M) {
                machine.add(new Pair(making + 1, coffee_times[making]));
                target = Math.min(target, coffee_times[making]);

                making += 1;
            }
            int n = machine.size();
            int next = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                Pair now = machine.poll();
                if(now.time == target){
                    answer[finished] = now.idx;
                    finished += 1;
                }else{
                    machine.add(new Pair(now.idx, now.time - target));
                    next = Math.min(next, now.time - target);
                }
            }
            target = next;
        }
        return answer;
    }
    public static void main(String[] args) {
        int [] answer = solution(3, new int [] {4,2,2,5,3});
        for(int time : answer){
            System.out.println(time);
        }
        answer = solution(1, new int [] {100,1,50,1,1});
        for(int time : answer){
            System.out.println(time);
        }
    }
}
