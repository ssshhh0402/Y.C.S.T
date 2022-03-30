package LV3;

import java.util.ArrayList;
import java.util.Collections;

public class 백십옮기기 {
    static ArrayList<String> al;
    public static String[] solution(String[] s){
        String [] answers = new String[s.length];
        int n, idx;
        for(int i = 0; i < s.length; i++){
            al = new ArrayList<String>();
            String target = s[i];
            n = target.length();
            if(target.contains("110")){
                idx = target.indexOf("110");
            }
            Collections.sort(al);
            answers[i] = al.get(0);
        }
        return answers;
    }
    public static void main(String[] args){
        String [] s = new String [] {"1110","100111100","0111111010"};
        String[] answers = solution(s);
        for(String answer : answers){
            System.out.println(answer);
        }
    }
}
