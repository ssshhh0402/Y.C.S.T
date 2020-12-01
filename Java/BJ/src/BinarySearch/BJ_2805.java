package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        String [] temps = br.readLine().split(" ");
        int [] base = new int[N];
        for(int idx = 0; idx < N; idx++){
            base[idx] = Integer.parseInt(temps[idx]);
        }
        Arrays.sort(base);
        int start = 0;
        int end = base[N-1];
        int mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            long total = 0;
            for(int item : base){
                if (item > mid){
                    total += (item- mid);
                }
            }
            if (total >= M){
                start = mid+1;
            }else if (total < M){
                end = mid-1;
            }
        }
        System.out.println(end);
        }
}
