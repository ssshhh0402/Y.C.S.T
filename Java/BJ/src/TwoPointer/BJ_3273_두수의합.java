package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_3273_두수의합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] base = new long[N];
        String[] inputs = br.readLine().split(" ");
        int X = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N; i++){
            base[i] = Long.parseLong(inputs[i]);
        }
        Arrays.sort(base);
        int s = 0, e = N-1, answer = 0;
        while(s < e){
            if(e == N){
                break;
            }
            long now = base[s] + base[e];
            if(now == X){
                answer += 1;
            }
            if(now < X){
                s += 1;
            }else{
                e -= 1;
            }
        }
        System.out.println(answer);
    }
}
