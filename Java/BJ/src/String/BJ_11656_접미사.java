package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_11656_접미사 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String base = br.readLine();
        ArrayList<String> answer = new ArrayList<String>();
        int N = base.length();
        for(int i = 1; i < N+1; i++){
            String temps = base.substring(N-i);
            answer.add(temps);
        }
        Collections.sort(answer);
        for(String item : answer){
            sb.append(item + "\n");
        }
        System.out.println(sb.toString());
    }
}
