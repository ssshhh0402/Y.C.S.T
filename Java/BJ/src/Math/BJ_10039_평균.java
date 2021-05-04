package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10039_평균 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int score;
        for(int i = 0;i < 5; i++){
            score = Integer.parseInt(br.readLine());
            if(score < 40){
                answer += 40;
            }else{
                answer += score;
            }
        }
        System.out.println(answer / 5);
    }
}
