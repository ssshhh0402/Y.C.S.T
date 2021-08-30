package Weekely;

import java.util.LinkedHashMap;
import java.util.Map;

public class FourthWeek {

    public static String solution(String[] table, String [] languages, int [] preferences){
        Map<String, Map<String, Integer>> base = new LinkedHashMap<String, Map<String, Integer>>();
        String[] inputs;
        for(String item : table){
            inputs = item.split(" ");
            Map<String, Integer> inner = new LinkedHashMap<String, Integer>();
            for(int i = 1; i < 6; i++){
                inner.put(inputs[i], 6 - i);
            }
            base.put(inputs[0], inner);
        }
        String result = "";
        int answer = Integer.MIN_VALUE;
        for(String key : base.keySet()){
            int temps = 0;
            Map<String, Integer> now = base.get(key);
            for(int i = 0 ; i < languages.length; i++){
                if(now.containsKey(languages[i])){
                    temps += (now.get(languages[i]) * preferences[i]);
                }
            }
            if(temps > answer){
                result = key;
                answer = temps;
            }else if(temps == answer){
                if(result.compareTo(key) > 0){
                    result = key;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        String [] table = new String [] {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String [] languages = new String [] {"PYTHON", "C++", "SQL"};
        int [] preferences = new int [] {7, 5, 5};
//        System.out.println(solution(table,languages, preferences));
        table = new String []{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        languages = new String [] {"JAVA", "JAVASCRIPT"};
        preferences = new int [] {7,5};
        System.out.println(solution(table,languages,preferences));
    }
}
