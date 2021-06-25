public class Lesson3_3 {
    public static int solution(int [] A){
        int N = A.length;
        int [] dp = new int[N];
        int answer = Integer.MAX_VALUE;
        dp[0] = A[0];
        for(int i = 1; i < N; i++){
            dp[i] = dp[i-1] + A[i];
        }
        for(int i = 1 ; i < N; i++){
            int one = dp[i] - A[i];
            int two = dp[N-1] - dp[i-1];
            int target = Math.abs(one - two);
            answer =  Math.min(answer, target);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int [] {3,1,2,4,3}));
    }
}
