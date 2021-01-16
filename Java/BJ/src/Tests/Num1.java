package Tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1 {
    static int answer = 0;
    static int maxCapacity;
    static void find(int sum, int idx, int[] base){
        if(sum <= maxCapacity){
            answer = Math.max(answer ,sum);
        }else{
            return;
        }

        for(int i = idx+1; i < base.length; i++){
            find(sum + base[i], i, base);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];
        for(int i = 0; i < N; i++){
            weights[i] = Integer.parseInt(br.readLine());
        }
        maxCapacity = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N; i++){
            find(weights[i], i, weights);
        }
        System.out.println(answer);
    }
}
