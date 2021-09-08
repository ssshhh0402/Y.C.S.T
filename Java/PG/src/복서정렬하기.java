import java.util.PriorityQueue;

public class 복서정렬하기 {
    static class Boxer implements Comparable<Boxer>{
        int weight, count,win,heavier, idx;
        double avg;

        Boxer(int a, int b){
            this.weight = a;
            this.count = 0;
            this.win = 0;
            this.heavier = 0;
            this.idx = b;
            this.avg = (double)0;
        }
        public void calc(){
            if(count != 0) {
                this.avg = ((double) ((double) win / (double) count)) * 100;
            }
        }
        public int compareTo(Boxer b){
            if(this.avg != b.avg){
                return (int)(b.avg - this.avg);
            }else{
                if(this.heavier != b.heavier){
                    return b.heavier - this.heavier;
                }else{
                    if(this.weight != b.weight){
                        return b.weight - this.weight;
                    }else{
                        return this.idx - b.idx;
                    }
                }
            }
        }
    }
    public static int [] solution(int [] weights, String[] head2head){
        int n = weights.length;
        int [] answer = new int[weights.length];
        PriorityQueue<Boxer> pq = new PriorityQueue<Boxer>();
        for(int i = 0 ; i < n;i++){
            Boxer now = new Boxer(weights[i],i+1);
            for(int j =  0 ; j < n; j++){
                if(i == j){
                    continue;
                }else{
                    char check = head2head[i].charAt(j);
                    if(check != 'N'){
                        now.count += 1;
                        if(check == 'W'){
                            now.win += 1;
                            if(weights[i] < weights[j]){
                                now.heavier += 1;
                            }
                        }
                    }
                }
            }
            now.calc();
            pq.add(now);
        }
        for(int i = 0 ; i < n; i++){
            Boxer now = pq.poll();
            answer[i] = now.idx;
        }
        return answer;
    }
    public static void main(String[] args){
        int [] weights = {50,82,75,120};
        String [] head2head = {"NLWL","WNLL","LWNW","WWLN"};
//        int [] answers = solution(weights, head2head);
//        for(int answer : answers){
//            System.out.println(answer);
//        }
//        System.out.println("______");
//        weights = new int [] {145,92,86};
//        head2head = new String [] {"NLW","WNL","LWN"};
//        answers = solution(weights, head2head);
//        for(int answer : answers){
//            System.out.println(answer);
//        }
//        System.out.println("____");
        weights = new int [] {60,70,60};
        head2head = new String [] {"NNN","NNN","NNN"};
        int [] answers = solution(weights, head2head);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
