package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2003_수들의합2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        int start = 0, end = 0, answer =0;
        long sum = 0;
        int[] base = new int[N];
        inputs = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        while(true){
            if(sum >= M){
                sum -= base[start++];
            }else if(end == N){
                break;
            }else{
                sum += base[end++];
            }
            if(sum == M){
                answer += 1;
            }
        }
        System.out.println(answer);

    }
}
