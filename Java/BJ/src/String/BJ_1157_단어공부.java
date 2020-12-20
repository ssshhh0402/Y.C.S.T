package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_1157_단어공부 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> base = new HashMap<String, Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().toUpperCase().split("");
        for(String input : inputs){
            if(base.containsKey(input)){
                base.replace(input, base.get(input) + 1);
            }else{
                base.put(input, 1);
            }
        }
        String answer = "";
        int count = 0;
        for(String key : base.keySet()){
            if(base.get(key) > count){
                count = base.get(key);
                answer = key;
            }else if(base.get(key) == count){
                answer = "?";
            }
        }
        System.out.println(answer);
    }
}
