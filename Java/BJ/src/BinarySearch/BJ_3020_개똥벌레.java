package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3020_개똥벌레 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), H = Integer.parseInt(inputs[1]);
        int [] lower = new int [N / 2];
        int [] higher = new int [N / 2];
        for(int i = 0 ; i < N / 2; i++){
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            lower[i] = n;
            higher[i] = m;
        }
        int left = 0, right = H, broken = N, answer = 0;
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            int count = 0;
            for(int height : lower){
                if(height >= mid){
                    count += 1;
                }
            }
            for(int height : higher){
                if(H - height <= mid){
                    count += 1;
                }
            }
            if(count < broken){
                broken = count;
                answer = 1;
                left = mid+1;
            }else if(count == broken){
                answer += 1;
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(broken + " " + answer);
    }
}
