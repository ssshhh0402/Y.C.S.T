package Prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11441_합구하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] base = new int[N];
        int [] dp = new int[N];
        String [] inputs = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N; i++){
            if(i == 0){
                dp[i] = base[i];
            }else{
                dp[i] = dp[i-1] + base[i];
            }
        }
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0])-1, end = Integer.parseInt(inputs[1])-1;
            sb.append(dp[end] - dp[start] + base[start]+"\n");
        }
        System.out.println(sb.toString());
    }
}
