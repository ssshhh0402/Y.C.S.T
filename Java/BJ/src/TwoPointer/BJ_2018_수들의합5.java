package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2018_수들의합5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long s = 1, e = 1,sum = 0,count = 1;
        while(true){
            if(sum < N){
                sum += e;
                e += 1;
            }else if(e == N){
                break;
            }else{
                sum -= s;
                s += 1;
            }
            if(sum == N){
                 count += 1;
                 sum -= s;
                 s += 1;
            }
        }
        System.out.println(count);
    }

}
