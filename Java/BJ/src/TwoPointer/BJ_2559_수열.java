package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2559_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), K = Integer.parseInt(inputs[1]);
        int[] base = new int[N];
        inputs = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        int s=0, e=0, sum=0, answer=- Integer.MAX_VALUE,count = 0;
        while(s <= e){
            if(count < K){
                sum += base[e];
                e += 1;
                count += 1;
            }else if(e == N){
                break;
            }else{
                sum -= base[s];
                s += 1;
                count -= 1;
            }
            if(count == K){
                answer = Math.max(answer, sum);
            }
        }
        System.out.println(answer);
    }
}
