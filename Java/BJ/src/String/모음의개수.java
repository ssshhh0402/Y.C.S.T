package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모음의개수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] base = {"a","e","i","o","u"};
        String [] inputs= br.readLine().split("");
        int answer = 0;
        for(String input : inputs){
            if (input.equals("a") || input.equals("e") || input.equals("i") || input.equals("o") || input.equals("u")){
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
