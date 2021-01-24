package Prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2167_2차원배열합 {
    static String[] inputs;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs=  br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        int [][] base = new int[N+1][M+1];
        for(int x = 0; x < N; x++){
            inputs = br.readLine().split(" ");
            for(int y = 0 ; y < M; y++){
                base[x+1][y+1] = Integer.parseInt(inputs[y]);
            }
        }
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            inputs = br.readLine().split(" ");
            int count = 0;
            int x1 = Integer.parseInt(inputs[0]), y1 = Integer.parseInt(inputs[1]), x2 = Integer.parseInt(inputs[2]), y2 = Integer.parseInt(inputs[3]);
            for(int x = x1; x < x2+1; x++){
                for(int y = y1; y < y2+1; y++){
                    count += base[x][y];
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb.toString());
    }
}
