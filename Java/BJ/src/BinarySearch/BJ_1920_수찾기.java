package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1920_수찾기 {
    public static int binary(int start, int end, int target, int[] base){
        int mid = (start + end) / 2;
        if(mid >= end){
            return -1;
        }else{
            if(base[mid] == target){
                return 1;
            }else{
                if (base[mid] < target){
                    return binary(mid+1,end,target,base);
                }else{
                    return binary(start, mid, target, base);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] temps = br.readLine().split(" ");
        int []  base = new int[N];
        for(int idx =0; idx < N; idx++){
            base[idx] = Integer.parseInt(temps[idx]);
        }
        Arrays.sort(base);
        int M = Integer.parseInt(br.readLine());
        String[] temps2 = br.readLine().split(" ");
        for(int idx = 0; idx < M; idx++){
            Integer target = Integer.parseInt(temps2[idx]);
            int answer = binary(0,N,target,base);
            if(answer == -1){
                System.out.println("0");
            }else{
                System.out.println("1");
            }
        }

    }
}

