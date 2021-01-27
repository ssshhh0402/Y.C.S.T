package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1769_3의배수 {
    static String inputs;
    static int answer;
    static boolean flag = false;
    public static int calc(String inputs){
        String[] items = inputs.split("");
        int count = 0;
        for (String input : items){
            count += Integer.parseInt(input);
        }
        return count;
    }
    public static void find(String inputs, int count){
        int n = calc(inputs);
        if(inputs.length() == 1){
            answer = count;
            if(n%3 == 0){
                flag = true;
            }
        }else{
            find(String.valueOf(n), count+1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        inputs = br.readLine();
        find(inputs, 0);
        sb.append(answer + "\n");
        if(flag){
            sb.append("YES");
        }else{
            sb.append("NO");
        }
        System.out.println(sb.toString());
    }
}
