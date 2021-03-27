package Gabia;

import java.io.IOException;
import java.util.ArrayList;

public class Pro2 {
    static ArrayList<String> answer;
    static String [] inputs;
    static ArrayList<String> count;
    public static boolean pos(ArrayList<String> base){
        count = new ArrayList<String>();
        for(String item : base){
            if(count.contains(item)){
                return false;
            }else{
                count.add(item);
            }
        }
        return true;
    }
    public static void find(int idx, ArrayList<String> base) {
        String now = String.join("", base);
        if(!answer.contains(now)){
            answer.add(now);
        }
        if (idx != inputs.length - 1) {
            base.add(inputs[idx + 1]);
            if (pos(base)) {
                find(idx + 1, base);
                base.remove(base.size() - 1);
            }
        }
    }

    public static int solution(String s){
        answer = new ArrayList<String>();
        inputs = s.split("");
        ArrayList<String> base = new ArrayList<String>();
        for(int i = 0; i < inputs.length; i++){
            base.add(inputs[i]);
            find(i,base);
            base.clear();
        }
        return answer.size();
    }
    public static void main(String[] args) throws IOException{
        System.out.println(solution("abac"));
    }
}
