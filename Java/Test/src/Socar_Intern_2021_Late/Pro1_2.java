package Socar_Intern_2021_Late;

import java.util.*;

public class Pro1_2 {
    static ArrayList<Character> opens;
    static Map<Character, Character> m;
    static int answer,n, target_idx, start, end;
    public static Map<Character, Character> getMap(){
        Map<Character, Character> m = new LinkedHashMap<Character, Character>();
        m.put('(', ')');
        m.put(')', '(');
        m.put('[',']');
        m.put(']','[');
        m.put('{','}');
        m.put('}','{');
        return m;
    }
    public static void getOpens(String s){
        Stack<Character> st = new Stack<Character>();
        for(int i = n-1; i >= 0; i--){
            char now = s.charAt(i);
            if(!opens.contains(now)){
                st.add(now);
            }else{
                if(st.isEmpty()){
                    target_idx = i;
                    end = n;
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
                    end = i-1;
                }else{
                    start = i;
                    break;
                }
            }
        }

    }
    public static void getCloses(String s){
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < n; i++){
            char now = s.charAt(i);
            if(opens.contains(now)){
                st.add(now);
            }else{
                if(st.isEmpty()){
                    target_idx = i;
                    start = 0;
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
                    start = i+1;
                }else{
                    end = i;
                    break;
                }
            }
        }
    }
    public static boolean isPerfect(String s){
        Stack<Character> st = new Stack<Character>();
        for(int i = s.length()-1; i >= 0; i--){
            char now = s.charAt(i);
            if(!opens.contains(s.charAt(i))){
                st.add(now);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char before = st.pop();
                if(m.get(now) != before){
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
        answer = 0;
        int count = 0;
        n = s.length();
        target_idx = -1;
        start = 0;
        end = n-1;
        opens = new ArrayList<Character>(Arrays.asList('(','[','{'));
        m = getMap();
        if(!opens.contains(s.charAt(0)) || opens.contains(s.charAt(n-1))){
            return 1;
        }
        for(int i = 0; i < n; i++){
            if(opens.contains(s.charAt(i))){
                count += 1;
            }else{
                count -= 1;
            }
        }
        if(count > 0){
            getOpens(s);
            char target = m.get(s.charAt(target_idx));
            for(int i = target_idx+1; i < end+1; i++){
                if(isPerfect(s.substring(start, i)+target+s.substring(i,n))){
                    answer += 1;
                }
            }
        }else{
            getCloses(s);
            char target = m.get(s.charAt(target_idx));
            char find = m.get(target);
            boolean flag = false;
//            for(int i = start; i < target_idx+1; i++){
//                char now = s.charAt(i);
//                if(flag && now == find){
//                    flag = false;
//                    continue;
//                }
//                if(opens.contains(now) && now != target){
//                    flag = true;
//                    find = m.get(now);
//                }else{
//
//                }
//            }
            while(start <= target_idx){
                char now = s.charAt(start);
                if(flag && now != find){
                    start += 1;
                    continue;
                }
                if(opens.contains(now) && now != target){
                    answer += 1;
                    flag = true;
                }else if(now == target || now == m.get(target)){
                    answer += 1;
                }
                start += 1;
            }
        }

        return answer;
    }
    public static void main(String[] args){
        String s = "(()()()"; // count +
//        System.out.println(solution(s));
        s = "()()()())";
        System.out.println(solution(s));
//        s = "[](][]){}";
//        System.out.println(solution(s));
    }
}
