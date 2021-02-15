import java.util.Arrays;

public class 최소값만들기 {
    public static int solution(int[] A, int[] B){
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int n = B.length;
        for(int i = 0 ;i < n; i++){
            answer += (A[i] * B[n-i-1]);
        }
        return answer;
    }
    public static void main(String[] args){
        int [] A = new int [] {1,4,2};
        int [] B = new int[] {5,4,4};
        System.out.println(solution(A,B));
    }
}
