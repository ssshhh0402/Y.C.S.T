import java.util.Arrays;

public class Lesson6_1 {
    public static int solution(int [] A){
        Arrays.sort(A);
        if(A.length == 0){
            return 0;
        }
        int answer = 1;

        for(int i = 1; i < A.length; i++){
            if(A[i] != A[i-1]){
                answer += 1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] A = new int [] {2,1,1,2,3,1};
        System.out.println(solution(A));
    }
}
