package OpenSurvey;

public class Pro1 {
    public static int solution(int b){
        int answer = Integer.MAX_VALUE;
        long B = b * b;
        long A, C;
        for(long c = b; c <= 500000; c++){
            for(long a = 1; a <= b; a++){
                A = a * a; C = c * c;
                if(A+B == C){
                    answer = (int)c;
                    break;
                }
            }
            if(answer == c){
                break;
            }
        }
        if(answer == Integer.MAX_VALUE){
            return -1;
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        int b = 12;
        System.out.println(solution(b));
        b = 200000;
        System.out.println(solution(b));
    }
}
