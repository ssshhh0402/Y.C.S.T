package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10162_전자렌지 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int [] time = new int [] {300, 60, 10};
        for(int i = 0; i < 3; i++){
            int now = T / time[i];
            sb.append(now).append(" ");
            T -= time[i] * now;
        }
        if(T != 0){
            System.out.println("-1");
        }else{
            System.out.println(sb.toString());
        }
    }
}
