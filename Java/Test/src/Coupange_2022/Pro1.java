package Coupange_2022;

public class Pro1 {
    public static int solution(int N, int [] sequence){
        int answer = 0;
        int now = 0;
        int next;
        for(int i = 0; i < N; i++){
            next = sequence[i]-1;
            if(now > next){
                answer += Math.min(now-next,N-now+next);               //Math.min(시계 정방향, 반대방향)
            }else{
                answer += Math.min(next-now, now+(N-next));                   //Math.min(시계 정방향, 반대방향)
            }
            now = next;
        }
        return answer;
    }
    public static void main(String[] args){
        int N = 5;
        int [] sequence = new int [] {1,2,3,4,5};
        N = 5;
        sequence = new int [] {3,5,4,1,2};
        System.out.println(solution(N, sequence));

    }
}