package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_11399_ATM {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] time = new int[N];
        String [] inputs = br.readLine().split(" ");
        int answer = 0;
        for(int i = 0; i < N; i++){
            time[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(time);
        for(int i = 0; i < N; i++){
            answer += (time[i] * (N-i));
        }
        System.out.println(answer);
    }
}
