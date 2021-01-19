package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1244_스위치 {
    static boolean [] base;
    static String [] inputs;
    static int N;
    public static void male(int target){
        for(int i = target; i < N+1; i += target){
            base[i] = !base[i];
        }
    }
    public static void female(int target){
        base[target] = !base[target];
        for(int i = 1; i < N; i++){
            if(target - i > 0 && target + i < N+1){
                if(base[target-i] == base[target+i]){
                    base[target-i] = !base[target-i];
                    base[target+i] = !base[target+i];
                }else{
                    break;
                }
            }else{
                break;
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        base = new boolean[N+1];
        inputs = br.readLine().split(" ");
        for(int i = 1 ; i < N+1; i++){
            if(inputs[i-1].equals("0")){
                base[i] = false;
            }else{
                base[i] = true;
            }
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int s = Integer.parseInt(inputs[0]), target = Integer.parseInt(inputs[1]);
            if(s == 1){
                male(target);
            }else{
                female(target);
            }
        }
        for(int i = 1; i < N+1; i++){
            if(!base[i]){
                sb.append("0 ");
            }else{
                sb.append("1 ");
            }
            if(i % 20 == 0){
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
