package Gabia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro1 {
    public static int solution(int n){
        int answer = 0;
        for(long i = 5; i < n+1; i *= 5){
            answer += (int)(n / i);
        }
        return answer;
    }
    public static long fact(int n){
        long count = 1;
        for(int i = 2;i < n+1; i++){
            count *= i;
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(5));
        System.out.println(solution(10));
        System.out.println(solution(11));
        System.out.println(solution(5));
        System.out.println(fact(5));
    }
}
