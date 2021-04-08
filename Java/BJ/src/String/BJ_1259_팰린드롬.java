package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1259_팰린드롬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = br.readLine().split("");
        boolean flag;
        while(!(inputs.length == 1 && inputs[0].equals("0"))){
            int n = inputs.length;
            flag = true;

            for(int i = 0; i < n / 2; i++){
                if(!inputs[i].equals(inputs[n-i-1])){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                sb.append("no\n");
            }else{
                sb.append("yes\n");
            }
            inputs = br.readLine().split("");
        }
        System.out.print(sb.toString());
    }
}

