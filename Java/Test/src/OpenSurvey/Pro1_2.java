package OpenSurvey;

public class Pro1_2 {
    public static int solution(int b){
        int answer = Integer.MAX_VALUE;
        double B = Math.pow(b, 2);
        double a,A, C;

        for(int c = b; c <= 500000; c++){
            C = Math.pow(c, 2);
            A = C- B;
            a = Math.sqrt(A);
            if(a % 1 == 0 && 1 <= a && a <= b){
                return c;
            }

        }
        return -1;
    }
    public static void main(String[] args){
        int b = 4;
//        System.out.println(solution(b));
        b = 400000;
//        System.out.println(solution(b));
        b = 5;
        System.out.println(solution(b));
    }
}
