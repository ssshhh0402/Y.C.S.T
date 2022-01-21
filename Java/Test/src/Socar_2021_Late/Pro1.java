package Socar_2021_Late;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class Pro1 {
    static int start_idx, end_idx;
    static class Item{
        char value;
        int idx;

        Item(char a, int b){
            this.value = a;
            this.idx = b;
        }
    }
    static Map<Character, Character> m;
    public static Map<Character, Character> init(){
        Map<Character, Character> m = new LinkedHashMap<Character, Character>();
        m.put('[', ']');
        m.put('{', '}');
        m.put('(', ')');
        return m;
    }
    public static boolean isRight(int idx, String s){
        Stack<Character> st = new Stack<Character>();
        for(int i = end_idx+1; i >= start_idx; i--){
            char now;
            if(i <= idx){
                now = s.charAt(i);
            }else{
                now = s.charAt(i-1);
            }
            if(now == ')' || now == ']' || now == '}'){
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
        int n = s.length();
        int target = -1;
        m = init();
        start_idx = -1;
        end_idx = -1;
        Stack<Item> st = new Stack<Item>();
        for(int i = n-1; i >= 0; i--){
            char now = s.charAt(i);
            if(now == ']' || now == '}' || now == ')'){
                st.add(new Item(now, i));
            }else{
                if(st.isEmpty()){
                    if(target == -1){
                        target = i;
                        continue;
                    }else{
                        start_idx = i;
                        end_idx = n;
                        break;
                    }
                }
                Item before = st.pop();
                if(before.value != m.get(now)){
                    target = i;
                    st.add(before);
                    continue;
                }
                if(target != -1 && st.isEmpty()){
                    start_idx = i;
                    end_idx = before.idx;
                    break;
                }
            }
        }
        if(target == -1 && !st.isEmpty()){
            target = 0;
            end_idx = n;
            start_idx = 0;

        }
        for(int i = start_idx; i < end_idx+1; i++){
            if(isRight(i,s)){
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
