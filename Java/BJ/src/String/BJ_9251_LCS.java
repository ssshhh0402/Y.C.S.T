package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9251_LCS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String one = br.readLine();
        String two = br.readLine();
        int answer = 0;
        int count = -1;
        for(int o = 0; o < one.length(); o++){
            for(int t = 0; t < two.length(); t++){
                if(one.charAt(o) == (two.charAt(t))){
                    if(t > count){
                        count = t;
                        answer += 1;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
