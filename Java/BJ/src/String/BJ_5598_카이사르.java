package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5598_카이사르 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        for(int i = 0 ; i < input.length();i++){
            int now = Character.hashCode(input.charAt(i)) - 3;
            if(now < 65){
                now = 91 - Math.abs(now - 65);
            }
            sb.append(Character.toChars(now));
        }
        System.out.print(sb.toString());
    }
}
