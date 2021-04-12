package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10942_팰린드롬 {
    static int [] base;
    public static int isPell(int start, int end){
        boolean flag = true;
        int max = end - start;
        for(int i = 0; i < max; i++){
            if(base[start+i] != base[end-i]){
                flag = false;
                break;
            }
        }
        if(flag){
            return 1;
        }else{
            return 0;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        base = new int[N+1];
        String [] inputs = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            base[i+1] = Integer.parseInt(inputs[i]);
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]);
            sb.append(isPell(start, end)).append("\n");
        }
        System.out.println(sb.toString());

    }
}
