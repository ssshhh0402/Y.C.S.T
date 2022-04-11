package StreaMe2;

import java.util.Stack;

public class Pro2 {
    public static class Item{
        Character value;
        int cost;
        Item(Character Value, int Cost){
            this.value = Value;
            this.cost = Cost;
        }
    }
    public static int solution(String S, int [] C){
        int answer = 0;
        Stack<Item> st = new Stack<Item>();
        for(int i = S.length()-1; i >= 0; i--){
            if(st.isEmpty()){
                st.add(new Item(S.charAt(i), C[i]));
            }else{
                Character nowValue = S.charAt(i);
                Integer nowCost = C[i];
                Item before = st.pop();
                if(before.value == nowValue){
                    if(nowCost >= before.cost){
                        answer += before.cost;
                        st.add(new Item(nowValue, nowCost));
                    }else{
                        answer += nowCost;
                        st.add(before);
                    }
                }else{
                    st.add(new Item(nowValue, nowCost));
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String S = "abccbd";
        int [] C = new int [] {0,1,2,3,4,5};
        System.out.println(solution(S, C));//answer = 2, word = "abcbd";
        S = "a";
        C = new int [] {1};
        System.out.println(solution(S,C));
        S = "aabbcc";
        C = new int [] {1,2,1,2,1,2};
        System.out.println(solution(S, C)); // answer = 3, word = "abc";
        S = "aaaa";
        C = new int [] {3,4,5,6};
        System.out.println(solution(S, C)); // answer = 12, word = "a";
        S = "ababa";
        C = new int [] {10,5,10,5,10};
        System.out.println(solution(S,C)); // answer = 0, word = "ababa";
    }
}
