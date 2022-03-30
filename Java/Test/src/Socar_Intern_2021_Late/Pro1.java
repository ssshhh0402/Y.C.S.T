package Socar_Intern_2021_Late;

import java.util.*;

public class Pro1 {
    ArrayList<Character> opens;
    Map<Character, Character> m;
    int answer, target_idx, start_idx, end_idx, n;
    public Map<Character, Character> getMap(){
        Map<Character, Character> m = new LinkedHashMap<Character, Character>();
        m.put('(', ')');
        m.put(')', '(');
        m.put('[', ']');
        m.put(']', '[');
        m.put('{', '}');
        m.put('}', '{');
        return m;
    }
    public void getOpens(String s, int count){
        Stack<Character> st = new Stack<Character>();
        for(int i = n-1; i >= 0; i--){
            char now = s.charAt(i);
            if(!opens.contains(now)){
                st.add(now);
            }else{
                if(st.isEmpty()){
                    target_idx = i;
                    end_idx = n;
                    continue;
                }
                char before = st.pop();
                if(m.get(before) != now){
                    target_idx = i;
                    st.add(before);
                }
            }
            if(st.isEmpty()){
                if(target_idx == -1){
                    end_idx = i-1;
                }else{
                    start_idx = i;
                    break;
                }
            }
        }
    }
    public void getCloses(String s){
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < n; i++){
            char now = s.charAt(i);
            if(opens.contains(now)){
                st.add(now);
            }else{
                if(st.isEmpty()){
                    target_idx = i;
                    start_idx = 0;
                    continue;
                }
                char before = st.pop();
                if(m.get(before) != now){
                    target_idx = i;
                    st.add(before);
                }
            }
            if(st.isEmpty()){
                if(target_idx == -1){
                    start_idx = i+1;
                }else{
                    end_idx = i;
                    break;
                }
            }
        }
    }
    public boolean isRight(String s){
        Stack<Character> st = new Stack<Character>();
        for(int i = s.length()-1; i >= 0; i--){
            char now = s.charAt(i);
            if(!opens.contains(now)){
                st.add(now);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char before = st.pop();
                if(m.get(before) != now){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public int solution(String s) {
        int answer = 0;
        int count = 0;
        n = s.length();
        target_idx = -1;
        start_idx = 0;
        end_idx = n - 1;
        opens = new ArrayList<Character>(Arrays.asList('(', '[', '{'));
        m = getMap();
        if (!opens.contains(s.charAt(0)) || opens.contains(s.charAt(n - 1))) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            if (opens.contains(s.charAt(i))) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        if (count > 0) {
//            getOpens(s);
            char target = m.get(s.charAt(target_idx));
//            for (int i = target_idx + 1; i <= end_idx; i++) {
//                if (isRight(s.substring(start_idx, i) + target + s.substring(i, n))) {
//                    answer += 1;
//                }
//            }
        } else {
            getCloses(s);
            char target = m.get(s.charAt(target_idx));
//            for (int i = start; i <= target_idx; i++) {
//                if (isRight(s.substring(start, i) + target + s.substring(i, n))) {
//                    answer += 1;
//                }
//            }
        }

        return answer;
    }
    public void main(String[] args){
        String s = "(()()()"; // count +
//        System.out.println(solution(s));
        s = "()()()())";
        System.out.println(solution(s));
//        s = "[](][]){}";
//        System.out.println(solution(s));
    }
}
