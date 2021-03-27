package Goorm.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro4 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String [] inputs = new String[N];
        for(int i = 0 ; i < N; i++){
            inputs[i] = br.readLine();
        }
        int M = Integer.parseInt(br.readLine());
        int count;
        for(int i = 0 ;i  < M; i++){
            String target = br.readLine();
            count = 0;
            for(String item : inputs){
                if(item.contains(target)){
                    count += 1;
                }
            }
            sb.append(count + "\n");
        }
        System.out.print(sb.toString());
    }
}
