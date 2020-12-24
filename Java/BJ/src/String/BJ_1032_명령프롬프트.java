package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1032_명령프롬프트 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] base = new String[N];
        for(int i = 0; i < N; i++){
            base[i] = br.readLine();
        }
        String answer = "";
        for(int i = 0 ; i < base[0].length(); i++){
            boolean flag =false;
            for(int j = 1; j < N; j++){
                if(base[0].charAt(i) != base[j].charAt(i)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                answer += base[0].charAt(i);
            }else{
                answer += "?";
            }
        }

        System.out.println(answer);

    }
}
