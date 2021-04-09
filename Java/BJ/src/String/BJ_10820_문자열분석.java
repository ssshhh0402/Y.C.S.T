package String;

import java.io.IOException;
import java.util.Scanner;

public class BJ_10820_문자열분석 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int U,L,S,N;
        String input = sc.nextLine();
        while(!input.equals("")){
            U = 0;
            L = 0;
            S = 0;
            N = 0;
            for(int i = 0 ; i < input.length(); i++){
                if(Character.isDigit(input.charAt(i))){
                    N += 1;
                }else if(Character.isLowerCase(input.charAt(i))){
                    L += 1;
                }else if(Character.isUpperCase(input.charAt(i))){
                    U += 1;
                }else if(input.charAt(i) == ' '){
                    S += 1;
                }
            }
            input = sc.nextLine();
            sb.append(L + " " + U + " " + N + " " + S + "\n");
        }
        sc.close();
        System.out.println(sb.toString());
    }
}
