package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1026_보물 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int [] B = new int[N];
        String[] inputs = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            A[i] = Integer.parseInt(inputs[i]);
        }
        inputs = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            B[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0 ; i < N; i++){
            answer += (A[i] * B[N-i-1]);

        }
        System.out.println(answer);
    }
}
