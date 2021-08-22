package Grab2021;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pro1 {
    public static boolean[] solution(String [] infos, String [] actions){
        Map<String, String> info =  new LinkedHashMap<String, String>();
        boolean logined = false;
        ArrayList<String> items = new ArrayList<String>();
        ArrayList<Boolean> answers = new ArrayList<Boolean>();

        String[] inputs;
        for(String i : infos){
            inputs = i.split(" ");
            info.put(inputs[0], inputs[1]);
        }
        for(String action : actions){
            inputs = action.split(" ");
            if(inputs[0].equals("ADD")){
                if(logined){
                    items.add(inputs[1]);
                    answers.add(true);
                }else{
                    answers.add(false);
                }
            }else if(inputs[0].equals("LOGIN")){
                String id = inputs[1], pwd = inputs[2];
                if(!logined){
                    if(info.containsKey(id) && info.get(id).equals(pwd)) {
                        logined = true;
                        answers.add(true);
                    }else{
                        answers.add(false);
                    }
                }else{
                    answers.add(false);
                }
            }else if(inputs[0].equals("ORDER")){
                if(items.size()!= 0){
                    answers.add(true);
                    items.clear();
                }else{
                    answers.add(false);
                }
            }
        }
        boolean [] answer = new boolean[answers.size()];
        for(int i = 0 ; i < answers.size(); i++){
            answer[i] = answers.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        String [] infos = {"kim password", "lee abc"};
        String [] actions = {"ADD 30", "LOGIN kim abc", "LOGIN lee password", "LOGIN kim password", "LOGIN kim password", "LOGIN lee abc", "ADD 30", "ORDER", "ORDER", "ADD 40", "ADD 50"};
        boolean [] answers = solution(infos, actions);
        for(boolean answer : answers){
            System.out.println(answer);
        }
    }
}
