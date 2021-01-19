package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11365_밀비급일 {
    static String inputs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            inputs = br.readLine();
            if(inputs.equals("END")){
                break;
            }else{
                for(int i = inputs.length()-1;i >= 0; i--){
                    sb.append(inputs.charAt(i));
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
