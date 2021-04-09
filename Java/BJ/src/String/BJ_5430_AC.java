package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_5430_AC {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String [] inputs, temps;
        String [] base;
        int n;
        boolean flag;
        while(T -- > 0){
            inputs = br.readLine().split("");
            flag = true;
            n = Integer.parseInt(br.readLine());
            base = new String[n];
            int count = 0;
            temps= br.readLine().split("\\[|,|\\]");
            for(String temp : temps){
                if(!temp.equals("")){
                    base[count] = temp;
                    count += 1;
                }
            }

//            for(String input : inputs){
//                if(input.equals("R")){
//                    Collections.reverse(base);
//                }else{
//                    if(base.isEmpty()){
//                        flag = false;
//                        sb.append("error\n");
//                    }
//                    ArrayList<String> newOne = new ArrayList<String>();
//                    for(int i = 1; i < base.size(); i++){
//                        newOne.add(base.get(i));
//                    }
//                    base = newOne;
//                }
//            }
//            if(flag) {
//                sb.append("[");
//                for (int i = 0; i < base.size(); i++) {
//                    sb.append(base.get(i));
//                    if (i == base.size() - 1) {
//                        sb.append("]");
//                    } else {
//                        sb.append(',');
//                    }
//                }
//                sb.append('\n');
//            }
        }
        System.out.println(sb.toString());
    }
}
