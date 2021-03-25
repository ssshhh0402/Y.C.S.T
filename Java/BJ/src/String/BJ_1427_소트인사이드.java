package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1427_소트인사이드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = br.readLine().split("");
        int N = inputs.length;
        int [] base = new int [N];
        for(int i = 0 ; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(base);
        for(int i = N-1; i >= 0; i--){
            sb.append(base[i]);
        }
        System.out.println(sb.toString());
    }
}
