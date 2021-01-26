package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15565_귀여움 {
    static String[] inputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), K = Integer.parseInt(inputs[1]);
        inputs = br.readLine().split(" ");
        int [] base = new int[N];
        for(int i = 0; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        int start = 0,end=0,count = 0;
        while(start <= end){
            if(base[end] == 1){
                start += 1;
                count += 1;
            }else if(end == N){
                break;
            }else{
                end += 1;
            }
        }

    }
}
