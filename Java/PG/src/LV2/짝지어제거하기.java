package LV2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 짝지어제거하기 {
    public static int solution(String s){
        String [] ss = s.split("");
        Stack<String> q = new Stack<String>();
        int n = s.length();
        for(int i= 0; i < n; i++){
            if(q.size() == 0){
                q.add(ss[i]);
            }else{
                String before = q.pop();
                if(!before.equals(ss[i])){
                    q.add(before);
                    q.add(ss[i]);
                }
            }
        }
        if(q.size() == 0){
            return 1;
        }else{
            return 0;
        }
    }
    public static void main(String[] args){
        String s=  "baabaa";
        System.out.println(solution(s));
        s = "CDCD";
        System.out.println(solution(s));
    }
}
