package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class BJ_1373_2진수8진수 {
    static StringBuilder sb;
    static String[] inputs;
    static ArrayList<Double> al;
    public static void find(ArrayList<Double> items){
        int target = 0;
        for(Double item : items){
            target += item;
        }
        while(true){
            sb.append(target % 8);
            if(target / 8 == 0){
                break;
            }else{
                target = target / 8;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        al = new ArrayList<Double>();
        inputs = br.readLine().split("");
        BigInteger count = BigInteger.valueOf(0);
        for(int i =0; i < inputs.length; i++){

            count += BigInteger.valueOf(Integer.parseInt(inputs[inputs.length-i-1]) * Math.pow(2,i));
            if(i % 3 == 2){
                find(al);
                al.clear();
            }
        }
        find(al);
        System.out.println(sb.reverse().toString());

    }
}
