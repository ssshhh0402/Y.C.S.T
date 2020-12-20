package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ_11719_그대로출력하기2 {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String inputs = sc.nextLine();
            System.out.println(inputs);
        }
        sc.close();
    }
}
