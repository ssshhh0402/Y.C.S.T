package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11000_하얀칸 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        for(int x = 0; x < 8; x++){
            String[] inputs = br.readLine().split("");
            for(int y = 0; y < 8; y++){
                if (x % 2 == 0){
                    if(y % 2 == 0 && inputs[y].equals("F")){
                        answer += 1;
                    }
                }else{
                    if(y % 2 == 1 && inputs[y].equals("F")){
                        answer += 1;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
