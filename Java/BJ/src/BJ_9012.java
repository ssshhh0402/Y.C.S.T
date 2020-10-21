import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;

public class BJ_9012 {
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int idx = 0 ; idx < N; idx++){
            String strings = br.readLine();
            LinkedList<Character> ll = new LinkedList<Character>();
            int n = strings.length();
            boolean flag = false;
            for(int i = n-1; i >= 0; i--){
                Character item = strings.charAt(i);
                if (item == ')'){
                    ll.add(item);
                }else{
                    if (!ll.isEmpty()){
                        ll.poll();
                    }else{
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag){
                if(ll.isEmpty()){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }else{
                System.out.println("NO");
            }
        }
    }
}
