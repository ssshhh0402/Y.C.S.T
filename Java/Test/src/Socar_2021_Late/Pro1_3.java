package Socar_2021_Late;

import java.util.*;

public class Pro1_3 {
    static class Item{
        char value;
        int idx;

        Item(char a, int b){
            this.value= a;
            this.idx = b;
        }
    }
    public static int solution(String s){
        int answer = 0;
        ArrayList<int[]> al = new ArrayList<int[]>();
        Map<Character, Character> m = new LinkedHashMap<Character, Character>();
        m.put('[', ']');
        m.put('{', '}');
        m.put('(', ')');
        Stack<Item> q = new Stack<>();
        int n = s.length();
        int end = n-1, idx = -1, start = 0;
        for(int i = n-1; i >= 0; i--){
            char now = s.charAt(i);
            if(now == '}' || now == ')' || now == ']'){
                q.add(new Item(now, i));
            }else{
                if(q.isEmpty()){
                    idx = i;
                    continue;
                }
                Item before = q.pop();
                if(m.get(now) != before.value) {
                    idx = i;
                    q.add(before);
                }else{
                    al.add(new int [] {i, before.idx});
                }
                if(q.isEmpty()){
                    if(idx == -1){
                        end = i-1;
                    }else{
                        start = i;
                        break;
                    }
                }
            }
        }
        if(s.charAt(idx) == '('){
            answer = idx - start;
        }else{
            answer = end - idx;
        }
        for(int[] item : al){
            if(item[0] > start && item[1] < idx){
                answer -= (item[1] - item[0]);
            }else if(item[0] > idx){
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String s = "[]([[]){}";
//        System.out.println(solution(s));
        s = "(()()()"			;
        System.out.println(solution(s));
    }
}
