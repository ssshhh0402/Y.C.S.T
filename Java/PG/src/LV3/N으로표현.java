package LV3;

public class N으로표현 {
    static int answer;
    public static void recursive(int N, int number, int count, int sum){
        if(count > 8){
            return;
        }
        if(sum == number){
            answer = Math.min(answer, count);
            return;
        }
        int X = N;
        for(int i = 1; i <= 8 - count; i++){
            recursive(N, number , i+count, sum + X);
            recursive(N, number, i+count, sum - X);
            recursive(N, number, i+count, sum * X);
            recursive(N, number, i + count, sum / X);
            X = (10*X)+N;
        }
    }
    public static int solution(int N, int number){
        answer = Integer.MAX_VALUE;
        recursive(N, number, 0, 0);
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        return answer;
    }
    public static void main(String[] args){
        int N= 5;
        int number = 12;
        System.out.println(solution(N, number));
    }
}
