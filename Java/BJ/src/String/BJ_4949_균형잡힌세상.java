package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> st;
        String input = br.readLine();
        boolean flag;
        int N;
        while(!input.equals(".")){
            N = input.length();
            st = new Stack<Character>();
            flag = false;
            for(int x = N-1; x >= 0; x--){
                if(input.charAt(x) == ')' || input.charAt(x) == ']'){
                    st.add(input.charAt(x));
                }else if(input.charAt(x) == '('){
                    if(st.size() != 0 && st.peek() == ')'){
                        st.pop();
                    }else{
                        sb.append("no\n");
                        flag = true;
                        break;
                    }
                }else if(input.charAt(x) == '['){
                    if(st.size() != 0 && st.peek() == ']'){
                        st.pop();
                    }else{
                        sb.append("no\n");
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
                if(st.size() == 0){
                    sb.append("yes\n");
                }else{
                    sb.append("no\n");
                }
            }

            input = br.readLine();
        }
        System.out.println(sb.toString());
    }
}
