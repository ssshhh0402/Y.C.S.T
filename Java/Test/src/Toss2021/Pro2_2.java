package Toss2021;

import java.util.ArrayList;
import java.util.Arrays;

public class Pro2_2 {
    public static int [] solution(int[] fruitWeights, int k){
        int n = fruitWeights.length;
        int [] dp = new int[n];
        ArrayList<Integer> sums = new ArrayList<Integer>();
        dp[0] = fruitWeights[0];
        for(int i = 1; i < n; i++){
            if(i < k){
                dp[i] = dp[i-1] + fruitWeights[i];
            }else{
                dp[i] = dp[i-1] + fruitWeights[i] - fruitWeights[i-k];
                if(!sums.contains(dp[i])){
                    sums.add(dp[i]);
                }
            }
        }
        int [] answer = new int[sums.size()];
        for(int i = 0 ; i < sums.size(); i++){
            answer[i] = sums.get(i);
        }
        Arrays.sort(answer);
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
