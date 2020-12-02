package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int K = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);
        long [] base = new long[K];
        for(int i = 0; i < K; i++){
            base[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(base);
        long start = 1;
        long end = base[K-1];
        long mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            int count = 0;
            for (long item : base){
                if(item >= mid){
                    count += item / mid;
                }
            }
            if (count >= N){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
