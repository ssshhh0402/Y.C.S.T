package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10809_알파벳찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temps = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String inputs = br.readLine();
        String answer = "";
        for(String item : temps){
            if (inputs.contains(item)){
                answer += (inputs.indexOf(item)) + " ";
            }
            else{
                answer += "-1 ";
            }
        }
        System.out.println(answer);
    }
}
