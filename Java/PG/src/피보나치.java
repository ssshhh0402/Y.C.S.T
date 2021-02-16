import java.util.ArrayList;

public class 피보나치 {
    public static int solution(int n){
        int [] base = new int [n+1];
        base[1] = 1;
        for(int i = 2; i < n+1; i++){
            base[i] = (base[i-1] + base[i-2]) % 1234567;
        }
        return base[n];
    }
    public static void main(String[] args){
        System.out.println(solution(5));
    }
}
