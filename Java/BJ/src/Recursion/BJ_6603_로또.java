package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_6603_로또 {
    static int N;
    static String[] inputs;
    static StringBuilder sb;
    public static void find(int idx, int count, ArrayList<Integer> temps){
        if(count == 6){
            for(Integer item : temps){
                sb.append(item + " ");
            }
            sb.append( "\n");
            return;
        }
        for(int i = idx+1; i < N+1; i++){
            temps.add(Integer.parseInt(inputs[i]));
            find(i, count+1, temps);
            temps.remove(temps.size()-1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while(true){
            inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);
            if(N == 0){
                break;
            }else{
                ArrayList<Integer> temps = new ArrayList<Integer>();
                for(int i = 1 ; i < N+1; i++){
                    temps.add(Integer.parseInt(inputs[i]));
                    find(i,1,temps);
                    temps.remove(temps.size()-1);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
