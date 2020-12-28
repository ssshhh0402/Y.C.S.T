package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2467_용액 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] base = new int[N];
        String [] inputs = br.readLine().split(" ");
        for(int i = 0 ; i< N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        int s=0,e=N-1,a_s=0,a_e=0,sum=2000000001;
        while(s < e && e < N){
            int now = base[s] + base[e];
            if(Math.abs(now) < sum){
                a_s = s;
                a_e = e;
                sum = Math.abs(now);
            }
            if(now < 0){
                s += 1;
            }else{
                e -= 1;
            }
        }
        System.out.println(base[a_s] + " " + base[a_e]);
    }
}
