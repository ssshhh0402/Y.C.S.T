package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2230_수고르기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int [] base = new int[N];
        for(int i = 0 ; i < N; i++){
            base[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(base);
        int s = 0, e = N-1;
        int answer = Integer.MAX_VALUE;
        while(s <= e && s < N){
            int sum = Math.abs(base[s] - base[e]);
            if(sum < M){
                s += 1;
            }else{
                e -= 1;
                answer = Math.min(answer, sum);
            }
        }
        System.out.println(answer);
    }
}
