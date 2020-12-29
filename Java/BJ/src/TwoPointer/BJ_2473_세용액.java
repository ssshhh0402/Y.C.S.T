package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2473_세용액 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] base = new long[N];
        String[] inputs = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            base[i] = Long.parseLong(inputs[i]);
        }
        Arrays.sort(base);
        int idx=0;
        long[] answers = new long[3];
        long answer = 3000000000L;
        while(idx != N-2){
            long temps = base[idx];
            int s=idx+1,e=N-1;
            while(s < e && e < N){
                long now = base[s] + base[e] + temps;
                if(Math.abs(now) < answer){
                    answer = Math.abs(now);
                    answers[0] = base[s];
                    answers[1] = base[idx];
                    answers[2] = base[e];
                }
                if(now < 0){
                    s += 1;
                }else{
                    e -= 1;
                }
            }
            idx += 1;
        }
        Arrays.sort(answers);
        String a = "";
        for(int i = 0 ; i < 3; i++){
            a += String.valueOf(answers[i]) + " ";
        }
        System.out.println(a);
    }
}
