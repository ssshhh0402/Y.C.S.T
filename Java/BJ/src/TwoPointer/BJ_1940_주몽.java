package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1940_주몽 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int [] base = new int[N];
        String[] inputs = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(base);
        int s=0, e = N-1, answer = 0 ;
        while (s < e){
            int count = base[s]+base[e];
            if(count == M){
                answer += 1;
                s += 1;
                e -= 1;
            }else if(count < M){
                s += 1;
            }else{
                e -= 1;
            }
        }
        System.out.println(answer);
    }
}
