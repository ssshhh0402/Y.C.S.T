package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2588_곱셈 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inputs;
        ArrayList<Integer>[] base = new ArrayList[2];
        int answer = 0;
        for(int i =0;i < 2; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < 2; i++){
            inputs = br.readLine().split("");
            for(int j = 0; j < inputs.length; j++){
                base[i].add(Integer.parseInt(inputs[j]));
            }
        }
        int count = 0;
        for(int i = base[1].size()-1; i >= 0; i--){
            int inner_c = 0;
            int temps = 0;
            int target = base[1].get(i);
            for(int j = base[0].size()-1; j >= 0; j--){
                temps += base[0].get(j) * target * Math.pow(10, inner_c);
                inner_c += 1;
            }
            sb.append(temps).append("\n");
            answer += temps * Math.pow(10, count);
            count += 1;
        }
        sb.append(answer);
        System.out.print(sb.toString());
    }
}
