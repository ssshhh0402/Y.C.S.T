package Grip;

import java.util.PriorityQueue;

public class Pro4 {
    // 삼각형 조건?
    // z(가장긴변) < i + j
    public int find(int a, int target){
        int count = 0;
        return count;
    }

    public static int solution(int n){
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 1; i < 10; i++){
            pq.add(i);
        }
        pq.remove(4);
        int k = pq.size();
        for(int i = 0 ; i < k; i++){
            System.out.println(pq.poll());
        }
        for(int i = 1; i < (n / 3) + 1; i++){
            for(int j = (n - i) / 2; j >= i; j--){
                int z = (n - i - j);
                if(z < i + j){
                    answer += 1;
                }else{
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int n = 9;
        System.out.println(solution(n));
    }
}
