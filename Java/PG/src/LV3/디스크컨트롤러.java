package LV3;


import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    static class Job implements Comparable<Job>{
        int start, end;

        Job(int a, int b){
            this.start = a;
            this.end = b;
        }
        public int compareTo(Job j){
            if(this.end == j.end){
                return this.start - j.start;
            }else{
                return this.end - j.end;
            }
        }
    }
    public static int solution(int [][] jobs){
        int answer = 0; //시간
        int n = jobs.length;
        int end = 0;
        PriorityQueue<Job> pq = new PriorityQueue<Job>();
        for(int i = 0 ; i < n; i++){
            pq.add(new Job(jobs[i][0],jobs[i][1]));
        }
        Job now = pq.poll();
        while(true){
            if(now.start <= end){
                answer += (end - now.start) + now.end;
                end += now.end;
                if(pq.size() == 0){
                    break;
                }
                now = pq.poll();
            }else{
                int target = Integer.MAX_VALUE;
                Job j;
                answer += (now.end);
                end = now.start + now.end;
                if(pq.size() == 0){
                    break;
                }

            }
        }
//        for(int i = 0 ; i < n; i++){
//            Job now = pq.poll();
//            if(now.start <= end){
//                answer += (end- now.start) + now.end;
//                end += now.end;
//            }else{
//                answer += (now.end - now.start);
//                end = now.start + now.end;
//            }
//        }
        return answer / n;
    }
    public static void main(String[] args){
        int [][] jobs = new int [][] {{0, 3}, {5, 17}, {10, 12}};
        System.out.println(solution(jobs));
    }
}
