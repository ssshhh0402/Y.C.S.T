package Prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11659_구간합 {
    static String[] inputs;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        int[] base = new int[N];
        inputs = br.readLine().split(" ");
        for(int i = 0 ;i < N; i++){
            if(i == 0){
                base[i] = Integer.parseInt(inputs[i]);
            }else{
                base[i] = base[i-1] + Integer.parseInt(inputs[i]);
            }
        }
        for(int i = 0 ;i < M; i++){
            String [] now = br.readLine().split(" ");
            int start = Integer.parseInt(now[0])-1,end = Integer.parseInt(now[1])-1;
            int count = base[end] - base[start] + Integer.parseInt(inputs[start]);

            sb.append(count + "\n");
        }
        System.out.println(sb.toString());
    }
}
