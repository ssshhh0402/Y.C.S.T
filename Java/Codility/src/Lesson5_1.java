public class Lesson5_1 {
    public static int solution(int A, int B, int K){
        int a = A / K;
        int b = B / K;
        int c  = 0 ;
        if(A % K == 0){
            c += 1;
        }
        return b - a + c;
    }
    public static void main(String[] args){
        System.out.println(solution(5,11,2));
        System.out.println(solution(0,2000000000,2000000000));
        System.out.println(solution(0,0,11));
    }
}
