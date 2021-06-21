package Topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2637_장난감 {
    public static class Item{
        int next, count;

        Item(int a, int b){
            this.next = a;
            this.count = b;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int [][] base = new int[N+1][N+1];
        int [] degree = new int[N+1];
        int X,Y,K;
        String [] inputs;
        for(int i = 0; i < M; i++){
            inputs = br.readLine().split(" ");
            X = Integer.parseInt(inputs[0]);
            Y = Integer.parseInt(inputs[1]);
            K = Integer.parseInt(inputs[2]);
            degree[X] += 1;
        }
    }
}
