package Street11;

public class Pro3 {
    public static int solution(int [] A){
        int answer = 0;
        int before = A[0];
        int count = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] == before){
                count += 1;
            }else{
                answer += Math.min(count, Math.abs(before - count));
                count = 1;
                before = A[i];
            }
        }
        answer += Math.min(count, before - count);
        return answer;
    }
    public static void main(String[] args){
        int [] A = new int [] {1, 1, 3, 4, 4, 4};
//        System.out.println(solution(A));
        A = new int [] {1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4};
        System.out.println(solution(A));
    }
}
