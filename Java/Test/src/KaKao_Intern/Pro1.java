package KaKao_Intern;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Pro1 {
    public static int solution(String s){
        StringBuilder sb = new StringBuilder();
        Map<String, String> base = new LinkedHashMap<String, String>();
        base.put("zero", "0");
        base.put("one", "1");
        base.put("two", "2");
        base.put("three", "3");
        base.put("four", "4");
        base.put("five", "5");
        base.put("six", "6");
        base.put("seven", "7");
        base.put("eight", "8");
        base.put("nine", "9");

        String words = "";
        boolean flag = false;
        for(int i = 0 ; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }else{

                words += s.charAt(i);
                if(base.containsKey(words)){
                    sb.append(base.get(words));
                    words = "";
                }
            }
        }

        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("234567"));
        System.out.println(solution("123"));
    }

}
