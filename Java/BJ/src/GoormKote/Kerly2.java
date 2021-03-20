package GoormKote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kerly2 {
    static int answer = 0;
    public static void find(int now, int [] base){
        if(now == base.length - 1){
            answer += 1;
            return;
        }
        for(int i = 1; i < 3; i++){
            if(base[i] != 0 && now + i < base.length){
                find(now+i, base);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] inputs;
        int [] base = new int[N];
        inputs = br.readLine().split("");
        for(int i = 0; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        for(int i = 1; i < 3; i++){
            if(base[i] != 0) {
                find(i, base);
            }
        }
    }
}
