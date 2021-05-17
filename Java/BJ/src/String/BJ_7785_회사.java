package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_7785_회사 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Boolean> names = new LinkedHashMap<String, Boolean>();
        int n = Integer.parseInt(br.readLine());
        String[] inputs;
        for(int i = 0; i < n; i++){
            inputs = br.readLine().split(" ");
            if(inputs[1].equals("enter")){
                names.put(inputs[0], true);
            }else{
                names.replace(inputs[0], false);
            }
        }
        ArrayList<String> keys = new ArrayList(names.keySet());
        Collections.sort(keys);
        for(int i = keys.size()-1; i>= 0; i--){
            if(names.get(keys.get(i))){
                System.out.println(keys.get(i));
            }
        }
        }
    }

