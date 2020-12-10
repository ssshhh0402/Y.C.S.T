package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1072_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        long X = Long.parseLong(inputs[0]);
        long Y = Long.parseLong(inputs[1]);
        long Z = (Y*100) / X;
        if(Z >= 99){
            System.out.println(-1);
        }else{
            long start = 1;
            long end = X;
            long mid = 0;
            while(start <= end){
                mid = (start + end) / 2;
                long rat = ((Y+mid) * 100) / (X+mid);
                if (rat > Z){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            System.out.println(start);
        }
    }
}
