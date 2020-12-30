import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1712_손익분기점 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        long A = Long.parseLong(inputs[0]), B = Long.parseLong(inputs[1]), C = Long.parseLong(inputs[2]);
        int answer = -1;
        if(B < C){
            answer = (int)(A / (C-B)) + 1;
        }
        System.out.println(answer);

    }
}
