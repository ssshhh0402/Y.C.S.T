package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10808_알파벳갯수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("");
        int[] base = new int[123];
        String answer = "";
        for(String input : inputs){
            base[input.hashCode()] += 1;
        }
        for(int i = 97; i < 123; i++){
            if(i == 122){
                answer += String.valueOf(base[i]);
            }else {
                answer += String.valueOf(base[i]) + " ";
            }
        }
        System.out.println(answer);
    }
}
