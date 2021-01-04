package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10798_세로 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int count = 0;
        String[] base = new String[6];
        for(int i = 0; i < 5; i++){
            String inputs = br.readLine();
            count = Math.max(count, inputs.length());
            base[i] = inputs;
        }
        for(int i = 0; i < count; i++){
            int temps = 0;
            while(temps < 5){
                if(i < base[temps].length()){
                    sb.append(base[temps].charAt(i));
                }
                temps += 1;
            }
        }
        System.out.println(sb.toString());
    }
}
