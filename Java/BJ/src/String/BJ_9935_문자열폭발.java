package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9935_문자열폭발 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<Character>();
        String base = br.readLine();
        String target = br.readLine();
        int m = target.length();
        for(int i = 0 ; i < base.length(); i++){
            st.push(base.charAt(i));
            if(st.size() >= m && st.peek() == target.charAt(0)){
                boolean find = true;
                for(int j = 1; j < m; j++){
                    if(st.get(st.size()-1-j) != target.charAt(j)){
                        find = false;
                        break;
                    }
                }
                if(find){
                    for(int j = 0; j < m; j++){
                        st.pop();
                    }
                }
            }
        }
        if(st.empty()){
            System.out.println("FRULLA");
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < st.size(); i++){
                sb.append(st.pop());
            }
            System.out.print(sb.toString());
        }

    }
}
