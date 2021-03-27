package Goorm.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro2 {
    public static long comb(long now, int target){
        long upper = 1;
        long lower = 1;
        for(int i = 0 ; i < target; i ++){
            upper *= now - i;
            lower *= (i+1);
        }
        return (long)(upper / lower);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String [] inputs;
        int answer;
        for(int i = 0 ; i < N; i++){
            inputs = br.readLine().split(" ");
            long start = Long.parseLong(inputs[0]);
            long end = Long.parseLong(inputs[1]);
            if(start < 5){
                sb.append("1" + "\n");
            }else{
                answer = 0;
                for(int j = 5; j < start; j++){
                    if(j > 12){
                        break;
                    }
                    answer += (comb(start, j) * comb(end, 12 - j));
                }
                sb.append(answer + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
