package String;

import java.io.IOException;
import java.util.Scanner;

public class BJ_11718_그대로출력하기 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        String input;
        StringBuilder sb = new StringBuilder();
        while(sc.hasNextLine()){
            input= sc.nextLine();
            sb.append(input + "\n");
        }
        System.out.println(sb.toString());
    }
}
