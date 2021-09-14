package Weekely;

import java.util.ArrayList;
import java.util.Arrays;

public class SeventhWeek2 {
    public static int [] solution(int [] enter, int [] leave){
        int n = enter.length;
        int [] answer=  new int[n];
        ArrayList<Integer> ins = new ArrayList<Integer>(), outs = new ArrayList<Integer>();
        for(int i = 0 ; i < n; i++){
            ins.add(enter[i]);
            outs.add(leave[i]);
        }
        for(int i = 1; i < n+1; i++){
            int target_in = ins.indexOf(i);
            int target_out = outs.indexOf(i);
            for(int j = 0 ; j < target_in; j++){                                            //먼저 들어오고 나중에 나감
                int now_out = outs.indexOf(enter[j]);
                if(target_out < now_out){
                    answer[i-1]+=1;
                }
            }
            for(int j = target_in + 1; j < n; j++){                                             //나중에 들어오고 먼저 나감
                int temps2 = enter[j];
                int now_out = outs.indexOf(enter[j]);
                if(target_out > now_out){
                    answer[i-1] += 1;
                }
            }
            // 먼저 들어왔다가 나중에 나간 사람
            // 나중에 들어왔다가 먼저 나간사람
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
