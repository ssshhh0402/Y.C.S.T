package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11721_열개씩끊어서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String base = br.readLine();
        String answer = "";
        int count = 1;
        for(int i = 0 ; i < base.length(); i++){
            if(i == (10 * count - 1)){
                answer += base.charAt(i) + "\n";
                count += 1;
            }else{
                answer += base.charAt(i);
            }
        }
        System.out.println(answer);
    }
}
