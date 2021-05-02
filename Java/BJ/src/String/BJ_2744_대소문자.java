package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2744_대소문자 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String inputs = br.readLine();
        for(int i = 0 ; i < inputs.length(); i++){
            Character target = inputs.charAt(i);
            if(Character.isUpperCase(target)){
                sb.append(Character.toLowerCase(target));
            }else{
                sb.append(Character.toUpperCase(target));
            }
        }
        System.out.print(sb.toString());
    }
}
