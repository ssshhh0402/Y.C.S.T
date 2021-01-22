package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class BJ_1159_농구 {
    static String inputs;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> base = new LinkedHashMap<>();
        ArrayList<Character> answer = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            inputs = br.readLine();
            char target = inputs.charAt(0);
            if(base.containsKey(target) && !answer.contains(target)){
                int now = base.get(target)+1;
                if(now == 5){
                    answer.add(target);
                }else {
                    base.replace(target, now);
                }
            }else{
                base.put(target, 1);
            }
        }
        if(answer.size() == 0){
            System.out.println("PREDAJA");
        }else{
            Collections.sort(answer);
            StringBuilder sb = new StringBuilder();
            for(char item : answer){
                sb.append(item);
            }
            System.out.println(sb.toString());
        }
    }
}
