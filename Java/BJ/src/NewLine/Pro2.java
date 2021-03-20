package NewLine;

import java.util.*;

public class Pro2 {

    public static int [] solution(String inp_str){
        int[] answer = {};
        String Pos = "~!@#$%^&*";
        ArrayList<Integer> base = new ArrayList<Integer>();
        ArrayList<Integer> kinds = new ArrayList<Integer>();
        Map<Character, Integer> counting = new LinkedHashMap<Character, Integer>();
        boolean [] used = new boolean[6];
        if(inp_str.length() < 8 || inp_str.length() > 15){
            base.add(1);
        }                                                       //1번
        for(int i = 0; i < inp_str.length(); i++){
            char target = inp_str.charAt(i);
            int count = 1;
            // -1 && False && False => 다 False면 안들어
            if(!Character.isAlphabetic(target) && !Character.isDigit(target)){
                if(Pos.indexOf(target) == -1){
                    if(!used[2]){
                        base.add(2);
                        used[2] = true;
                    }
                }
            }
            if(Character.isAlphabetic(target)){
                if(Character.isLowerCase(target)){
                    if(!kinds.contains(1)) {
                        kinds.add(1);
                    }
                }else{
                    if(!kinds.contains(2)) {
                        kinds.add(2);
                    }
                }
            }else{
                if(Character.isDigit(target)){
                    kinds.add(3);
                }else{
                    if(Pos.indexOf(target) == -1){
                        if(!used[2]){
                            base.add(2);
                            used[2] = true;
                        }
                    }else{
                        kinds.add(4);
                    }
                }
            }
            if(counting.containsKey(target)){
                counting.replace(target, counting.get(target)+1);
            }else{
                counting.put(target, 1);
            }
            while(count < 4 && i + count < inp_str.length()){
                if(inp_str.charAt(i+count) == target){
                    count += 1;
                }else{
                    break;
                }
            }
            if(count == 4){
                if(!used[4]) {
                    base.add(4);
                    used[4] = true;
                }
            }
        }
        if(kinds.size() < 3){
            base.add(3);
        }
        for(Character key : counting.keySet()){
            if(counting.get(key) >= 5){
                base.add(5);
            }
        }

        Collections.sort(base);
        if(base.size() == 0){
            answer = new int[1];
        }else {
            answer = new int[base.size()];
            for (int i = 0; i < base.size(); i++) {
                answer[i] = base.get(i);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] answers = solution("AaTa+!12-3");
        for(int answer : answers){
            System.out.println(answer);
        }
        System.out.println("----");
        answers = solution("aaaaZZZZ)");
        for(int answer : answers){
            System.out.println(answer);
        }
        System.out.println("----");

        answers = solution("CaCbCgCdC888834A");
        for(int answer : answers){
            System.out.println(answer);
        }
        System.out.println("----");
        answers = solution("ZzZz9Z824");
        for(int answer : answers){
            System.out.println(answer);
        }
        System.out.println("----");
        answers = solution("UUUUU");
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
