package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class BJ_9375_패션왕 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Map<String, ArrayList<String>> base;
        String [] input;
        int n;
        while(T -- > 0){
            n = Integer.parseInt(br.readLine());
            base = new LinkedHashMap<String, ArrayList<String>>();
            for(int i = 0; i < n; i++){
                input = br.readLine().split(" ");
                if(base.containsKey(input[1])){
                    ArrayList<String> temps = base.get(input[1]);
                    temps.add(input[0]);
                    base.replace(input[1], temps);
                }else{
                    ArrayList<String> temps = new ArrayList<String>();
                    temps.add(input[0]);
                    base.put(input[1], temps);
                }
            }
            int answer = 1;
            for(String key : base.keySet()){
                answer *= (base.get(key).size()+1);
            }
            sb.append(answer - 1 + "\n");
        }
        System.out.print(sb.toString());

    }
}
