package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10952_AB5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs;
        while(true){
            inputs = br.readLine().split(" ");
            if(inputs[0].equals("0") && inputs[1].equals("0")){
                break;
            }
            sb.append(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1])).append("\n");
        }
        System.out.print(sb.toString());
    }
}
