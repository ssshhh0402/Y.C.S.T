package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9093_단어뒤집기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] inputs;
        while(N -- > 0){
            inputs = br.readLine().split(" ");
            for(String input : inputs){
                for(int i = input.length()-1; i >= 0; i--){
                    sb.append(input.charAt(i));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
