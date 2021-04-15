package Monthly;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Pro2 {
    static int n, answer;
    public static boolean isCorrect(String now){
        Stack<Character> st = new Stack<Character>();
        boolean flag = true;
        for(int i = n-1; i >= 0; i--){
            if(now.charAt(i) == ')' | now.charAt(i) == ']' || now.charAt(i) == '}'){
                st.push(now.charAt(i));
            }else{
                if(st.empty()){
                    flag = false;
                    break;
                }
                if(now.charAt(i) == '('){
                    if(st.peek() == ')'){
                        st.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }else if(now.charAt(i) == '['){
                    if(st.peek() == ']'){
                        st.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }else if(now.charAt(i) == '{'){
                    if(st.peek() == '}'){
                        st.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
        }
        if(flag && st.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    public static void find(int count, String now){
        if(count == n){
            return;
        }
        if(isCorrect(now)){
            answer += 1;
        }
        find(count+1, now.substring(1, n) + now.charAt(0));

    }
    public static int solution(String s){
        answer = 0;
        n = s.length();
        find(0, s);

        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }
}
