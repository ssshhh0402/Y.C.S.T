public class 두정수 {
    public static long solution(int a, int b){
        long answer = 0;
        if(a == b){
            return a;
        }else if(a > b){
            for(int i = b; i < a+1; i++){
                answer += i;
            }
        }else{
            for(int i = a; i < b+1; i++){
                answer += i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(3,5));
        System.out.println(solution(3,3));
        System.out.println(solution(5,3));
    }
}
