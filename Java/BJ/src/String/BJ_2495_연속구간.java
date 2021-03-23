package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2495_연속구간 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs;
        String target;
        int count ;
        int answer;
        for(int i = 0; i < 3; i++){
            inputs = br.readLine().split("");
            target = inputs[0];
            count = 1;
            answer = 0;
            for(int j = 1; j < inputs.length; j++){
                if (inputs[j].equals(target)) {
                    count += 1;
                }else{
                    answer = Math.max(count, answer);
                    target = inputs[j];
                    count = 1;
                }
            }
            answer = Math.max(answer, count);
            sb.append(answer + "\n");
        }
        System.out.println(sb.toString());
    }
}

