import java.util.PriorityQueue;

public class 더맵게 {
    public static int solution(int[] scoville, int k){
        int answer = 0;
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int item : scoville){
            pq.add(item);
        }
        while(pq.size() > 1){
            int one = pq.poll();
            int two = pq.poll();
            if(one >= k){
                answer = count;
                break;
            }
            pq.add(one + (two * 2));
            count += 1;
        }
        if(answer != 0){
            return answer;
        }else{
            if(pq.peek() >= k){
                return answer;
            }else{
                return -1;
            }
        }
    }
    public static void main(String[] args){
        int [][] temps = new int [][] {{}};
        System.out.println(solution(new int [] {1,2,3,9,10,12},7));
    }
}
