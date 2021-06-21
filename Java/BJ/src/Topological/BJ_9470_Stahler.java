package Topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_9470_Stahler {
    public static class Item{
        int toGo, stahler;

        Item(int a, int b){
            this.toGo = a;
            this.stahler = b;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer>[]base;
        String [] inputs;
        while(T -- > 0){
            inputs=  br.readLine().split(" ");
            int K = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]), P = Integer.parseInt(inputs[2]);
            base = new ArrayList[M+1];
            for(int i = 1 ; i < M+1; i++){
                base[i] = new ArrayList<Integer>();
            }
            int [] degree = new int[M+1];
            int [] stahlers = new int[M+1];
            for(int i = 0 ; i < P; i++){
                inputs = br.readLine().split(" ");
                int start = Integer.parseInt(inputs[0]), end = Integer.parseInt(inputs[1]);
                degree[end] +=1;
                base[start].add(end);
            }
        }
    }
}
