package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11720_숫자의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String[] inputs = br.readLine().split("");
        for(String item : inputs){
            answer += Integer.parseInt(item);
        }
        System.out.println(answer);
    }
}
