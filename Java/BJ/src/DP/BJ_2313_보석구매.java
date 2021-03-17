package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2313_보석구매 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int n;
        int [] base, dp;
        int start, end, sum;
        int answer_s, answer_e, answer_sum;
        int answer = 0;
        ArrayList<int[]> answers = new ArrayList<int[]>();
        String [] inputs;
        while(T -- > 0){
            n = Integer.parseInt(br.readLine());
            start = 0;
            end = 0;
            sum = 0;
            answer_s = 0;
            answer_e = 0;
            answer_sum = 0;
            base = new int[n];
            dp = new int[n];
            inputs = br.readLine().split(" ");
            for(int i = 0 ; i < n; i++){
                base[i] = Integer.parseInt(inputs[i]);
            }
            dp[0] = base[0];
            for(int i = 1; i < n; i++){
                int one = dp[i-1] + base[i];
                int two = base[i];
                if(one > two){
                    dp[i] = one;
                    end = i;
                }else{
                    dp[i] = two;
                    start = i;
                    end = i;
                }
                if(dp[i] > answer_sum){
                    answer_sum = dp[i];
                }else if(dp[i] == answer_sum){
                    if(end - start < answer_e - answer_s){
                        answer_s = start;
                        answer_e = end;
                    }else if(end - start == answer_e - answer_s){
                        if(answer_s > start){
                            answer_s = start;
                            answer_e = end;
                        }else if(answer_s == start){
                            if(answer_e > end){
                                answer_e = end;
                            }
                        }
                    }
                }
            }
            answer += answer_sum;
            answers.add(new int[] {answer_s, answer_e});
        }
        sb.append(answer + "\n");
        for(int [] item : answers){
            sb.append(item[0] + " " + item[1] + "\n");
        }
        System.out.println(sb.toString());
    }
}
