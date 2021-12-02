package LV2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 괄호회전하기 {
    public static boolean isPossible(String target){
        String [] targets = target.split("");
        Stack<String> q = new Stack<String>();
        for(int i = targets.length-1; i >= 0; i--){
            if(targets[i].equals("}") || targets[i].equals(")") || targets[i].equals("]")){
                q.add(targets[i]);
            }else{
                if(q.isEmpty()){
                    return false;
                }
                String before = q.pop();
                if(targets[i].equals("{") && !before.equals("}")){
                    return false;
                }else if(targets[i].equals("[") && !before.equals("]")){
                    return false;
                }else if(targets[i].equals("(") && !before.equals(")")){
                    return false;
                }
            }
        }
        if(q.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static int solution(String s){
        int answer = 0;
        int n = s.length();
        for(int i =0; i < n; i++){
            String target = s.substring(i,n) + s.substring(0,i);
            if(isPossible(target)){
                answer += 1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String s = "}]()[{";
        System.out.println(solution(s));
    }
}
