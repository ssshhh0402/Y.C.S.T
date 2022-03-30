package LV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 튜플 {
    public static int [] solution(String s){
        ArrayList<Integer> result = new ArrayList<Integer>();
        s = s.substring(2, s.length()-2);
        s = s.replace("},{", "-");
        String [] ss = s.split("-");
        Arrays.sort(ss, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        for(String target : ss){
            String [] now = target.split(",");
            for(String num : now){
                int n = Integer.valueOf(num);
                if(!result.contains(n)){
                    result.add(n);
                }
            }
        }
        int [] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    public static void main(String[] args){
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int [] answers = solution(s);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
