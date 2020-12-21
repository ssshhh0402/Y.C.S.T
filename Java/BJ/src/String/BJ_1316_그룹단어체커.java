package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        while(N -- > 0){
            String word = br.readLine();
            ArrayList<Character> count = new ArrayList<Character>();
            char temps = ' ';
            boolean flag = false;
            for(int i = 0 ; i < word.length(); i++){
                char now = word.charAt(i);
                if(temps != now){
                    if(!count.contains(now)){
                        count.add(now);
                        temps = now;
                    }else{
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
