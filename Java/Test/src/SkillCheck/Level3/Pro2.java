package SkillCheck.Level3;

import java.util.ArrayList;

public class Pro2 {

    public static int[] solution(int n, int s){
        if(s < n){
            return new int [] {-1};
        }
        int [] answer = new int[n];
        for(int i = 0 ; i < n; i++){
            answer[i] = s / n;
        }
        for(int i = n-1; i >= n - (s % n); i--){
            answer[i] += 1;
        }
        return answer;
    }
    public static void main(String[] args){
        int n = 2, s = 9;
        int [] answers = solution(n,s);
        for(int answer : answers){
            System.out.println(answer);
        }
        n = 2;
        s = 1;
        answers = solution(n,s);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
