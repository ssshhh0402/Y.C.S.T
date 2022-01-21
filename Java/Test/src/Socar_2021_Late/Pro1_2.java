package Socar_2021_Late;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class Pro1_2 {
    static Map<Character, Character> m;
    public static Map<Character, Character> init(){
        Map<Character, Character> map = new LinkedHashMap<Character, Character>();
        map.put('[',']');
        map.put('(',')');
        map.put('{', '}');
        return map;
    }
    public static ArrayList<Character> getAl(int idx, char target, String s){
        ArrayList<Character> al = new ArrayList<Character>();
        for(int i = 0;i  < s.length();i++){
            if(i < idx){
                al.add(s.charAt(i));
            }else if(i == idx){
                al.add(target);
            }else{
                al.add(s.charAt(i-1));
            }
        }
        return al;
    }
    public static boolean isPossible(ArrayList<Character> al){
        Stack<Character> st = new Stack<Character>();
        for(int i = al.size()-1; i >= 0; i--){
            char now = al.get(i);
            if(now == ']' || now == '}' || now == ')'){
                st.add(now);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char before = st.pop();
                if(before != m.get(now)){
                    return false;
                }
            }
        }
        if(!st.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    public static int solution(String s){
        int answer = 0;
        Stack<Character> st = new Stack<Character>();
        m = init();
        char target = ' ';
        for(int i = s.length()-1; i >= 0; i--){
            char now = s.charAt(i);
            if(now == ')' || now == ']' || now == '}'){
                st.add(now);
            }else{
                if(st.isEmpty()){
                    target = now;
                    break;
                }
                char before = st.pop();
                if(before != m.get(now)){
                    target = now;
                    break;
                }
            }
        }
        if(target == ' ' && !st.isEmpty()){
            target = st.pop();
        }
        for(int i = 0; i < s.length(); i++){
            ArrayList<Character> items = getAl(i,target,s);
            if(isPossible(items)){
                answer += 1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String s = "[]([[]){}";
        System.out.println(solution(s));
    }
}
