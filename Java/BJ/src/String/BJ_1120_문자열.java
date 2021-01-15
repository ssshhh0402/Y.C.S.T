package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1120_문자열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int answer = Integer.MAX_VALUE;
        int N = inputs[0].length();
        for(int i = 0 ; i <= inputs[1].length() - inputs[0].length(); i++){
            int count = 0;
            for(int j=0; j < N; j++) {
                if(inputs[0].charAt(j) != inputs[1].charAt(i+j))
                    count++;
            }
            answer = Math.min(count, answer);
        }
        System.out.println(answer);
    }
}
