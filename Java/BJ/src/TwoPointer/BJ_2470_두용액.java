package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2470_두용액 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] base = new int[N];
        String[] inputs = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(base);
        int s = 0, e= N-1, count = 2000000000, answer_s = 0, answer_e = 0;
        while(s < e){
            int now = base[s] + base[e];
            if(Math.abs(now) < count){
                count = Math.abs(now);
                answer_s = s;
                answer_e = e;
            }
            if( now < 0){
                s += 1;
            }else{
                e -= 1;
            }

        }
        System.out.println(String.valueOf(base[answer_s]) + " " + String.valueOf(base[answer_e]));
    }

}
