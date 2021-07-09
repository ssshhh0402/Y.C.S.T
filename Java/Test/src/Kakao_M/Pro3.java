package Kakao_M;

public class Pro3 {
    public static int solution(int [] A){
        if(A.length == 1) {
            return 1;
        }
        int answer = 0, O = A[0], E = A[1], S = 0;
        for(int i = 2; i < A.length; i++){
            if(i % 2 == 0 && A[i] != O){
                answer = Math.max(answer, i - S);
                S = i-1;
                O = A[i];
                E = A[i-1];
            }else if (i % 2 == 1 && A[i] != E){
                answer = Math.max(answer, i - S);
                S = i-1;
                O = A[i-1];
                E = A[i];
            }
        }
        answer = Math.max(answer ,A.length - S);
        return answer;
    }
    public static void main(String[] args){
        int [] A = new int [] {3,2,3,2,3};
        System.out.println(solution(A));
        A = new int [] {7,4,-2,4,-2,9};
        System.out.println(solution(A));
        A = new int [] {7,-5,-5,-5,7,-5};
        System.out.println(solution(A));
        A = new int [] {4};
        System.out.println(solution(A));
    }
}
