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
        int [] base;
        long [] dp;
        int start, end;
        int answer_s, answer_e;
        long answer_sum;
        long answer = 0;
        ArrayList<long[]> answers = new ArrayList<long[]>();
        String [] inputs;
        while(T -- > 0){
            n = Integer.parseInt(br.readLine());
            start = 1;
            end = 1;
            answer_s = 1;
            answer_e = 1;
            answer_sum = 0;
            base = new int[n];
            dp = new long [n];
            inputs = br.readLine().split(" ");
            for(int i = 0 ; i < n; i++){
                base[i] = Integer.parseInt(inputs[i]);
            }
            dp[0] = base[0];
            for(int i = 1; i < n; i++){
                long one = dp[i-1] + base[i];
                int two = base[i];
                if(one > two){
                    dp[i] = one;
                    end = i+1;
                }else{
                    dp[i] = two;
                    start = i+1;
                    end = i+1;
                }
                if(dp[i] > answer_sum){
                    answer_sum = dp[i];
                    answer_s = start;
                    answer_e = end;
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
            answers.add(new long [] {answer_s, answer_e});
        }
        sb.append(answer + "\n");
        for(long [] item : answers){
            sb.append(item[0] + " " + item[1] + "\n");
        }
        System.out.println(sb.toString());
    }
}
