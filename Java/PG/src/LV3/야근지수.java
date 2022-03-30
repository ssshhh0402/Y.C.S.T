package LV3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 야근지수 {
    public static int solution(int [] works , int n){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int work : works){
            pq.add(work);
        }
        int count = 0;
        while(count < n){
            int highest = pq.poll();
            if(highest < 0){
                break;
            }
            pq.add(highest - 1);
            count += 1;
        }
        int answer = 0;
        while(!pq.isEmpty()){
            answer += (int)Math.pow(pq.poll(), 2);
        }
        return answer;
    }
    public static void main(String[] args){
        int [] works = new int [] {4, 3, 3};
        int n = 4;
        n = 1;
        works = new int [] {2,1,2};
        System.out.println(solution(works, n));
    }
}
