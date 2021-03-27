package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1110_더하기싸이클 {
    static ArrayList<Integer> base;
    static int answer = 0;
    public static void find(ArrayList<Integer> temps, int count){
        if(base == temps){
            answer = count;
            return;
        }
        int first = temps.get(0);
        int second = temps.get(1);
        int third = first + second ;
        if(third >= 10){
            third = third % 10;
        }
        temps.clear();
        temps.add(second);
        temps.add(third);
        find(temps, count + 1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("");
        ArrayList<Integer> temps = new ArrayList<Integer>();
        base = new ArrayList<Integer>();
        for(String input : inputs){
            base.add(Integer.parseInt(input));
        }
        int first = base.get(0);
        int second = base.get(1);
        int third = first + second > 10 ? first + second % 10 : first + second;
        temps.add(second);
        temps.add(third);
        find(temps, 1);
        System.out.println(answer);
    }
}
