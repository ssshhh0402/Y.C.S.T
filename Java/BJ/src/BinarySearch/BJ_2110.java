package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int C = Integer.parseInt(inputs[1]);
        int[] base = new int[N];
        for(int i = 0; i < N; i++){
            base[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(base);
        int left = 0;
        int right = base[base.length-1];
        int mid = 0;
        int answer = 0;
        while(left <= right){
            mid = 0;
            int remove = 0;
            int last = 0;
            for(int item : base){
                if(item - last < mid){
                    remove += 1;
                }else{
                    last = item;
                }
            }
            if (remove == C){

            }
        }
    }
}
