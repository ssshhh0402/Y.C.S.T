import java.util.Arrays;

public class Lesson6_2 {
    public static int solution(int [] A){
        int N = A.length;
        Arrays.sort(A);
        int answer = A[N-1]*A[N-2]*A[N-3];
        if(A[0] < 0 && A[1] < 0 && A[2] > 0){
            int temps = A[0] * A[1] * A[N-1];
            return Math.max(answer, temps);
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        int [] A = new int [] {-3,1,2,-2,5,6};
//        System.out.println(solution(A));
        A = new int [] {-5, 5, -5, 4};
        System.out.println(solution(A));
    }
}
