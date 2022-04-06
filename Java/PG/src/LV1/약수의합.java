package LV1;

public class 약수의합 {
    public static int solution(int n){
        int answer = 0;
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                answer += i;
                if(i != Math.sqrt(n)){
                    answer += (n / i);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int n = 12;
        System.out.println(solution(n));
    }
}
