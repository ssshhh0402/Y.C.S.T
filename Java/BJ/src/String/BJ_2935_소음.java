package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_2935_소음 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        String comp = br.readLine();
        BigInteger b = new BigInteger(br.readLine());
        if(comp.equals("+")){
            System.out.println(a.add(b));
        }else{
            System.out.println(a.multiply(b));
        }
    }
}
