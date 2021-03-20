package GoormKote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kerly {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] inputs = br.readLine().split("");
        int [] base = new int[N+1];
        for(int i = 0 ; i < N; i++){
            base[i+1] = Integer.parseInt(inputs[i]);
        }
        int [] dp = new int[N+1];
        if(base[1] != 0){
            dp[1]  = 1;
        }
        if(base[2] != 0){
            if(base[1] == 0){
                dp[2] = 1;
            }else{
                dp[2] = 2;
            }
        }
        for(int i = 3; i < N+1; i++){
            if(base[i] != 0) {
                int one = dp[i - 1];
                int two = dp[i - 2];
                dp[i] = one + two;
            }
        }
        System.out.println(dp[N]);
        }
    }

