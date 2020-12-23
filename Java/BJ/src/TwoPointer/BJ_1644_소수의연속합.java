package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1644_소수의연속합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean [] check = new boolean[N+1];
        check[0] = true;
        check[1] = true;
        ArrayList<Integer> base = new ArrayList<Integer>();
        for(int i=2; i*i<=N; i++){
            if(!check[i]) {
                for(int j=i*i; j<=N; j+=i) {
                    check[j]=true;
                }
            }
        }
        for(int i=1; i<=N;i++){
            if(!check[i]) {
                base.add(i);
            }
        }
        int s = 0, e = 0, count = 0, answer = 0;
        while(s <= e){
            if(count >= N){
                count -= base.get(s);
                s += 1;
            }else if (e == base.size()){
                break;
            }else{
                count += base.get(e);
                e+= 1;
            }
            if(count == N){
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
