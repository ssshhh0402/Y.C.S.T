import java.util.ArrayList;
import java.util.HashSet;

public class Review {
    static HashSet<Integer> answer;
    static boolean [] used;
    static String [] numbers;
    static int n;
    public static boolean isPrime(int now){
        if(now < 2){
            return false;
        }else if(now == 2){
            return true;
        }
        for(int i = 2; i < Math.sqrt(now)+1; i++){
            if(now % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void find(String now){
        int N = Integer.parseInt(now);
        if(isPrime(N)){
            answer.add(N);
        }
        for(int i = 0 ; i < n; i++){
            if(!used[i]){
                used[i] = true;
                find(now + numbers[i]);
                used[i] = false;
            }
        }
    }
    public static int solution(String number){
        numbers = number.split("");
        answer = new HashSet<Integer>();
        n = numbers.length;
        used = new boolean[n];
        for(int i = 0; i < n; i++){
            used[i] = true;
            find(numbers[i]);
            used[i] = false;
        }
        return answer.size();
    }
    public static void main(String[] args){
        String N = "17";
        System.out.println(solution(N));
        N = "011";
        System.out.println(solution(N));
    }
}
