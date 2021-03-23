package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2495_연속구간2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inputs;
        String target;
        int count;
        int answer;
        for(int i = 0 ; i < 3; i++){
            inputs = br.readLine().split("");
            answer = 0;
            count = 0;
            target = "";
            for(int j = 0; j < inputs.length; j++){
                if(!target.equals(inputs[j])){
                    count = 0;
                    target = inputs[j];
                }
                count += 1;
                answer = Math.max(count, answer);
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb.toString());
    }
}
