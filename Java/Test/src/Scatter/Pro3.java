package Scatter;

import java.util.ArrayList;

public class Pro3 {
    public static boolean isPrime(int n){
        if(n < 2){
            return false;
        }else if(n == 2){
            return true;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static int solution(int N, int M){
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for(int i = 2; i <= N; i++){
            if(isPrime(i)){
                primes.add(i);
            }
        }
        int left = 0, right = 0, totalSum = 0, answer = 0;
        while(true){
            if(totalSum >= M){
                totalSum -= primes.get(left++);
            }else if(right == primes.size()){
                break;
            }else{
                totalSum += primes.get(right++);
            }
            if(totalSum == M){
                answer += 1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int N = 20;
        int M = 36;
        System.out.println(solution(N,M));
    }
}
