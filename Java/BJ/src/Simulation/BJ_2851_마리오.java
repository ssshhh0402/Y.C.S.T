package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class BJ_2851_마리오 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int diff = Integer.MAX_VALUE;
        int next = 0;
        for(int i = 0; i < 10; i++){
            next += Integer.parseInt(br.readLine());
            int d = Math.abs(100 - next);
            if(diff >= d){
                diff = d;
                answer = next;
            }else{
                if(next > 100){
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
