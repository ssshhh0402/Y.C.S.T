package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2850_수정렬하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] base = new int[N];
        for(int i = 0 ; i < N; i++){
            base[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(base);
        for(int item : base){
            sb.append(item + "\n");
        }
        System.out.println(sb.toString());
    }
}
