package LV3;

import java.util.Arrays;

public class 최고의집합 {
    public static int [] solution(int n, int s){
        if(n > s){
            return new int [] {-1};
        }
        int [] answers = new int[n];
        for(int i = 0 ; i < n; i++){
            answers[i] = s / n;
        }
        for(int i = 0 ; i < s % n; i++){
            answers[i] += 1;
        }
        Arrays.sort(answers);
        return answers;
    }
    public static void main(String[] args){
        int n = 2;
        int s = 9;
        int [] answers = solution(n,s);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
