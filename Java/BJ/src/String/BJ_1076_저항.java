package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_1076_저항 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> base = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        long answer = 0;
        base.put("black", 0);
        base.put("brown", 1);
        base.put("red", 2);
        base.put("orange", 3);
        base.put("yellow", 4);
        base.put("green", 5);
        base.put("blue", 6);
        base.put("violet", 7);
        base.put("grey", 8);
        base.put("white", 9);
        for(int i = 0 ; i < 3; i++){
            String input = br.readLine();
            if(i != 2){
                sb.append(base.get(input));
            }else{
                answer = Long.valueOf(sb.toString()) * (long)Math.pow(10, base.get(input));
            }
        }
        System.out.println(answer);

    }
}
