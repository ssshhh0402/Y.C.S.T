package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2789_유학금지 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String[] base = "CAMBRIDGE".split("");
        String target = br.readLine();
        for(int i = 0 ; i < base.length; i++){
            target = target.replace(base[i], "");
        }
        System.out.println(target);
    }
}
