package Prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9527_1의개수 {
    public static int find(int target){
        int count;
        for(count = 0; target != 0; count++){
            target &=(target - 1);
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        long start = Long.parseLong(inputs[0]), end = Long.parseLong(inputs[1]);
        int [] dp = new int[(int)(end+1)];
        for(int i = 0; i < end+1; i++){
            if(i == 0){
                dp[i] = find(i);
            }else{
                dp[i] = find(i) + dp[i-1];
            }
        }
        System.out.println(dp[(int)end] - dp[(int)(start-1)]);
    }
}
