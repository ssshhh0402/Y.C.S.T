package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10953_AB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            String[] inputs = br.readLine().split(",");
            System.out.println(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]));
        }
    }
}
