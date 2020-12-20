package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1152_단어의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] answer = br.readLine().split(" ");
        int count = 0;
        for(int i = 0 ; i< answer.length; i++){
            if(!answer[i].equals("")){
                count += 1;
            }
        }
        System.out.println(count);
    }
}
