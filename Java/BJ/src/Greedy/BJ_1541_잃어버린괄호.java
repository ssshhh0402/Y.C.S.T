package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1541_잃어버린괄호 {
    public static int convert(String now){
        String [] items = now.split("\\+");
        int count = 0;
        for(String item : items){
            count += Integer.parseInt(item);
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int answer = 0;
        String [] base = target.split("-");
        for(int i = 0; i < base.length; i++){
            if(i == 0){
                answer = convert(base[i]);
            }else{
                answer -= convert(base[i]);
            }
        }
        System.out.println(answer);
    }
}
