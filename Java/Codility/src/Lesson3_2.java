import java.io.IOException;
import java.util.Arrays;

public class Lesson3_2 {
    public static int solution(int [] A){
        Arrays.sort(A);
        int answer = 0;
        if(A.length == 0){
            return 1;
        }
        for(int i = 1; i < A.length+1; i++){
            if(A[i-1] != i){
                answer = i;
                break;
            }
        }
        if(answer == 0){
            answer = A[A.length-1]+1;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        System.out.println(solution(new int [] {2,3,4,5}));
    }
}
