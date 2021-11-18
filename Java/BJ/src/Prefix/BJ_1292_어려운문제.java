package Prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1292_어려운문제 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        int count = 0;
        int value = 1;
        int [] dp = new int[M+1];
        for(int i = 1; i < M+1; i++){
            dp[i] = dp[i-1] + value;
            count += 1;
            if(count == value){
                count = 0;
                value += 1;
            }
        }
        System.out.println(dp[M] - dp[N-1]);

    }
}
