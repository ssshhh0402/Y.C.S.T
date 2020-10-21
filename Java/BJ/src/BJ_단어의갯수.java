import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;

public class BJ_단어의갯수 {
    static int answer = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> ll = new LinkedList<Character>();
        String strings = br.readLine();
        for(int idx = 0; idx < strings.length(); idx++) {
            char item = strings.charAt(idx);
            if (item != ' ') {
                ll.add(item);
            }else{
                if (ll.getLast() != ' ' && !ll.isEmpty()){
                    answer += 1;
                    ll.add(item);
                }
            }
        }
        System.out.println(answer);
    }
}
