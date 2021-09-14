package Weekely;

import java.util.ArrayList;
import java.util.Stack;

public class SeventhWeek {
    public static int [] solution(int [] enter, int [] leave){
        int n = enter.length;
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<Integer> leaves = new ArrayList<Integer>();
        for(int i = 0 ; i < n; i++){
            leaves.add(leave[i]);
        }
        int [] answer = new int[n];
        int out_count = 0;
        for(int i = 0 ; i < n; i++){
            int now = enter[i];
            s.add(now);
            if(s.contains(leave[out_count])){
                while(!s.isEmpty() && s.contains(leave[out_count])){
                    int idx = s.indexOf(leave[out_count]);
                    s.remove(idx);
                    answer[leave[out_count]-1] += s.size();
                    for(int S : s){
                        answer[S-1] += 1;
                    }
                    out_count += 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] enter = {1,3,2};
        int [] leave = {1,2,3};
        int [] answers = solution(enter, leave);
        for(int answer : answers){
            System.out.println(answer);
        }
        System.out.println("-_-_-_-_-_-_-_-_-_-_");
        enter = new int [] {1,4,2,3};
        leave = new int [] {2,1,3,4};
        answers = solution(enter, leave);
        for(int answer : answers){
            System.out.println(answer);
        }
        System.out.println("-_-_-_-_-_-_-_-_-_-_");
        enter = new int [] {3,2,1};
        leave = new int [] {2,1,3};
        answers = solution(enter, leave);
        for(int answer : answers){
            System.out.println(answer);
        }
        System.out.println("-_-_-_-_-_-_-_-_-_-_");
        enter = new int [] {3,2,1};
        leave = new int [] {1,3,2};
        answers = solution(enter, leave);
        for(int answer : answers){
            System.out.println(answer);
        }
        System.out.println("-_-_-_-_-_-_-_-_-_-_");
        enter = new int [] {1,4,2,3};
        leave = new int [] {2,1,4,3};
        answers = solution(enter, leave);
        for(int answer : answers){
            System.out.println(answer);
        }
        System.out.println("-_-_-_-_-_-_-_-_-_-_");

    }
}
