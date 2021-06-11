package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_7567_그릇 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("");
        long answer = 0;
        String target = "";
        for(int i = 0 ; i < inputs.length; i++){
            if(!inputs[i].equals(target)){
                answer += 10;
                target = inputs[i];
            }else{
                answer += 5;
            }
        }
        System.out.print(answer);
    }
}
