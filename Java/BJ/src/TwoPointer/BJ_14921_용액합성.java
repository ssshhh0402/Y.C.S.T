package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_14921_용액합성 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] base = new int[N];
        String[] inputs = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        int s=0,e=N-1,sum=0, count = 200000001, answer = 0;
        while(s < e){
            sum = base[s] + base[e];
            if (Math.abs(sum) <  count){
                count = Math.abs(sum);
                answer = sum;
            }
            if(sum < 0){
                s += 1;
            }else{
                e -= 1;
            }
        }
        System.out.println(answer);
    }
}
