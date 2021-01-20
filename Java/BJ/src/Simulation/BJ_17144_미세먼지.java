package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_17144_미세먼지 {
    static String[] inputs;
    static int[][] base;
    static ArrayList<Pair> dusts, machines;
    static class Pair{
        int x, y;

        Pair(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    public static int find(Pair now){
        int answer = 0;
        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]), C = Integer.parseInt(inputs[2]);
        base = new int[N][M];
        for(int x = 0; x < N; x++){
            inputs= br.readLine().split(" ");
            for(int y = 0 ; y < M; y++){
                if(inputs[y].equals("-1")){
                    machines.add(new Pair(x,y));
                }else if(!inputs[y].equals("0")){
                    dusts.add(new Pair(x,y));
                }
                base[x][y] = Integer.parseInt(inputs[y]);
            }
        }
        while(C -- > 0){
            for(Pair item : dusts){
                int count = find(item);
            }
        }

    }
}
