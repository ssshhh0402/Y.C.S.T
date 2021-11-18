import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class NaFi{

    public static int solution(String S) {
        int answer = 1;
        Stack<Character> st = new Stack<Character>();
        if (S.length() != 0) {
            int n = S.length();
            for (int i = n - 1; i >= 0; i--) {
                Character now = S.charAt(i);
                if(now == (']') || now == (')')||now == ('}')){
                    st.add(now);
                }else{
                    if(st.empty()){
                        answer = 0;
                        break;
                    }
                    char target = st.pop();
                    if(now == '(' && target != ')'){
                        answer = 0;
                        break;
                    }else if(now == '[' && target != ']'){
                        answer = 0;
                        break;
                    }else if(now == '{' && target != '}'){
                        answer = 0;
                        break;
                    }
                }
            }
        }
        if (answer == 1 && st.empty()) {
            return answer;
        } else {
            return 0;
        }
    }
    public static void main(String[] args){
        String s = "{[()()]}";
        System.out.println(solution(s));
    }
}