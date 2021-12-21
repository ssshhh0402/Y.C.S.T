package LV2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class 수식최대화 {
    public static ArrayList<String[]> init(){
        String [] opers = new String[] {"+","-", "*"};
        ArrayList<String[]> result = new ArrayList<String[]>();
        for(int a = 0; a < 3; a++){
            for(int b = 0; b < 3; b++){
                for(int c = 0; c < 3; c++){
                    if(a != b && b != c && c != a){
                        result.add(new String [] {opers[a],opers[b],opers[c]});
                    }
                }
            }
        }
        return result;
    }
    public static long find(ArrayList<String> expression, String[] order){
        for(String oper : order){
            for(int i = 0 ; i < expression.size(); i++){
                String now = expression.get(i);
                if(now.equals(oper)){
                    int before = Integer.parseInt(expression.get(i-1));
                    int next = Integer.parseInt(expression.get(i+1));
                    expression.remove(i-1);
                    expression.remove(i-1);
                    expression.remove(i-1);
                    long target = 0;
                    switch (oper){
                        case "+": target = before + next;
                        break;
                        case "-": target = before - next;
                        break;
                        case "*": target = before * next;
                        break;
                    }
                    expression.add(i-1, String.valueOf(target));
                    i = i-1;
                }
            }
        }
        return Long.parseLong(expression.get(0));
    }
    public static ArrayList<String> getNums(String expression){
        ArrayList<String> result = new ArrayList<String>();
        String num = "";
        for(int i = 0 ; i < expression.length(); i++){
            if(Character.isDigit(expression.charAt(i))){
                num+=expression.charAt(i);
            }else{
                result.add(num);
                result.add(String.valueOf(expression.charAt(i)));
                num = "";
            }
        }
        if(!num.equals("")){
            result.add(num);
        }
        return result;
    }
    public static long solution(String expression){
        ArrayList<String[]> orders = init();
        ArrayList<String> nums = getNums(expression);
        long answer = 0;
        for(String[] order : orders){
            ArrayList<String> temps = new ArrayList<String>();
            temps.addAll(nums);
            long result = Math.abs(find(temps, order));
            answer= Math.max(result, answer);
        }
        return answer;
    }
    public static void main(String[] args){
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }
}
