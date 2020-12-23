package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2902_KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("-");
        String answer = "";
        for(String input : inputs){
            answer += input.charAt(0);
        }
        System.out.println(answer);
    }
}
