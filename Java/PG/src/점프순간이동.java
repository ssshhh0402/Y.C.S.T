public class 점프순간이동 {
    public static int solution(int n){
        int answer = 1;
        while(n / 2 != 0){
            if(n % 2 != 0){
                answer += 1;
                n -= 1;
                continue;
            }
            n = n / 2;
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(5));
    }
}
