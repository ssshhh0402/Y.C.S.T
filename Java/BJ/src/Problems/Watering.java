package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Watering {
    static int answer = Integer.MAX_VALUE, N, C;
    static String [] inputs;
    static Pair [] base;
    static class Pair{
        int x, y;
        Pair(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    public static int count(Pair last, Pair now){
        int answer = (now.x - last.x) * (now.x - last.x) + (now.y - last.y) * (now.y - last.y);
        if(answer > C){
            return -1;
        }else{
            return answer;
        }
    }
    public static void find(int count, int sum, Pair last, int idx){
        if(count == N){
            answer = Math.min(answer, sum);
        }else{
            for(int i = idx+1 ; i < N; i++){
                int n = count(last, base[i]);
                if(n != -1){
                    find(count+1, sum + n, base[i], i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        N =  Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);
        base = new Pair[N];
        for(int i=0;i < N; i++){
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]), y = Integer.parseInt(inputs[1]);
            base[i] = new Pair(x, y);
        }
        for(int i = 0; i < N; i++){
            find(1,0,base[i], i);
        }
        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }
}
