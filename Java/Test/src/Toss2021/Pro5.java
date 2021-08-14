package Toss2021;

import java.util.*;

public class Pro5 {
    public static int [] solution(int [] fruitWeights, int k){
        ArrayList<Integer> sums = new ArrayList<Integer>();
        int start = 0, end = k;
        while(start <= (fruitWeights.length - k) && k <= fruitWeights.length){
            int max = 0;
            for(int i = start; i < end; i++){
                max = Math.max(max, fruitWeights[i]);
            }
            if(!sums.contains(max)){
                sums.add(max);
            }
            start += 1;
            end += 1;
        }
        Collections.sort(sums);
        int [] answer = new int[sums.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = sums.get(sums.size() - i - 1);
        }
        return answer;
    }
    public static void main(String[] args){
        int [] fruitWeights = new int [] {30,40,10,20,30};
        int k = 3;
        int [] answers = solution(fruitWeights, k);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
