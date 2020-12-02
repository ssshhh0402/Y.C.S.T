package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] base = new int[N];
        String[] inputs = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(base);
        int M = Integer.parseInt(br.readLine());
        int start = base[0];
        int end = base[N-1];
        int mid = 0;
        int comp = 0;
        int answer = 0;
        while(start <= end){
            mid = (start + end) / 2;
            int count = 0;
            for(int item : base){
                if (item > mid){
                    count += mid;
                }else{
                    count += item;
                }
            }
            if(count >= M){
                if(count > comp){
                    comp = count;
                    answer = end;
                }
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
    System.out.println(answer);
    }
}
