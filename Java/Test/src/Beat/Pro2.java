package Beat;

import java.util.PriorityQueue;

public class Pro2 {
    static class Circle implements Comparable<Circle>{
        int center_x, center_y, r;

        Circle(int a, int b, int c){
            this.center_x = a;
            this.center_y = b;
            this.r = c;
        }
        public int compareTo(Circle c){
            if(this.center_x == c.center_x){
                if(this.center_y == c.center_y){
                    return c.r - this.r;
                }else{
                    return this.center_y - c.center_y;
                }
            }else{
                return this.center_x - c.center_x;
            }
        }
    }
    public static int solution(int [][] circles){
        PriorityQueue<Circle> pq = new PriorityQueue<Circle>();
        for(int [] circle : circles){
            pq.add(new Circle(circle[0],circle[1],circle[2]));
        }
        int answer = 0;
        Circle before = pq.poll();
        int count = 1;
        while(!pq.isEmpty()){
            Circle now = pq.poll();
            int d = Math.abs(now.center_x - before.center_x) + Math.abs(now.center_y - before.center_y);
            if(d == (now.r + before.r) || d <= Math.abs(now.r - before.r)){
                count += 1;
            }else{
                answer = Math.max(count, answer);
                count = 1;
                before = now;
            }
        }
        if(answer == 0){
            return 1;
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        int [][] circles = new int [][] {{-4,0,2},{-4,0,4},{-4,0,6},{2,0,8}};
        System.out.println(solution(circles));
    }
}
