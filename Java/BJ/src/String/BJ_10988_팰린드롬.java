package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10988_팰린드롬 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] base = br.readLine().split("");
        int n = base.length;
        boolean flag = true;
        for(int i = 0 ; i < n / 2; i++){
            if(!base[i].equals(base[n-i-1])){
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
