package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1357_뒤집힌덧셈 {
    static StringBuilder sb;
    static String [] item;
    public static int Rev(int n){
        item = String.valueOf(n).split("");
        sb = new StringBuilder();
        for(int i = item.length - 1; i >= 0; i--){
            sb.append(item[i]);
        }
        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        System.out.println(Rev(Rev(N) + Rev(M)));
    }
}
