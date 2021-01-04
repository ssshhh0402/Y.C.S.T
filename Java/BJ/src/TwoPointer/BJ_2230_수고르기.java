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
        int s = 0, e = 0, answer= Integer.MAX_VALUE;
        while(s <= e && e < N){
            int sum = base[e] - base[s];
            if(sum < M){
                e += 1;
            }else{
                s += 1;
                answer = Math.min(answer, sum);
            }
        }
        System.out.println(answer);
    }
}
