package LV2;

import java.util.*;

public class 메뉴리뉴얼 {
    static Map<String, Integer> m;
    static int max;
    public static void recursive(String[] order, int count,int idx, String now, int course){
        if(count == course){
            if(m.containsKey(now)){
                int counting = m.get(now);
                m.replace(now, counting+1);
                max = Math.max(max, counting+1);

            }else{
                m.put(now, 1);
            }
            return;
        }
        for(int i = idx; i < order.length; i++){
            recursive(order, count + 1,i+1,now + order[i], course);
        }
    }

    public static String[] solution(String[] orders, int [] courses){
        ArrayList<String> al = new ArrayList<String>();
        for(int course : courses){
            m = new LinkedHashMap<String, Integer>();
            max = Integer.MIN_VALUE;

            for(String order : orders){
                String [] inputs = order.split("");
                Arrays.sort(inputs);
                recursive(inputs, 0,0,"",course);
            }
            if(max >= 2){
                for(String key : m.keySet()){
                    if(m.get(key) == max){
                        al.add(key);
                    }
                }
            }
        }
        Collections.sort(al);
        String [] answers = new String[al.size()];
        for(int i =0;i < al.size(); i++){
            answers[i] = al.get(i);
        }
        return answers;
    }
    public static void main(String[] args){
        String[] orders = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int [] courses = new int [] {2,3,4};
        String[] answers;
//      answers = solution(orders, courses);
//        for(String answer : answers){
//            System.out.println(answer);
//        }
        orders = new String [] {"XYZ", "XWY", "WXA"};
        courses = new int [] {2,3,4};
        answers = solution(orders, courses);
        for(String answer : answers){
            System.out.println(answer);
        }
    }
}
