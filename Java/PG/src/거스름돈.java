import java.util.Arrays;

public class 거스름돈 {
    public static int solution(int n, int[] money){
        int [][] dp = new int[money.length+1][n+1];
        int answer = 0;
        Arrays.sort(money);
        for(int i = 1; i < n+1; i++){
            answer += money[i];
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(5,new int [] {1,2,5} ));
    }
}
