package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[] base = new int[N];
        int answer = Integer.MAX_VALUE;
        int count = 0;
        inputs = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        int start = 0, end = 0, sum = 0;
        while(true){
            if(sum >= M){
                answer = Math.min(count, answer);
                sum -= base[start];
                start += 1;
                count -= 1;
            }
            else if(end == N){
                break;
            }
            else{
                sum += base[end];
                end += 1;
                count += 1;
            }
        }
        if(answer == Integer.MAX_VALUE){
            System.out.println(0);
        }else {
            System.out.println(answer);
        }
    }
}
