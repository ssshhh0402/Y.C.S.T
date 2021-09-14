package LV2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class 단체사진찍기 {
    static int answer;
    static String[] characters;
    static boolean [] used;
    static Map<String, ArrayList<Option>> options;
    static class Option{
        String target, fourth;
        int count;

        Option(String a, String b, int c){
            this.target = a;
            this.fourth = b;
            this.count = c;
        }
    }
    public static void setting(int n, String [] data){
        String [] option1, option2;
        for(int i = 0 ; i < n; i++){
            option1= data[i].split("~");
            option2 = option1[1].split("");
            if(options.containsKey(option1[0])){
                ArrayList<Option> now = options.get(option1[0]);
                now.add(new Option(option2[0],option2[1],Integer.parseInt(option2[2])));
                options.replace(option1[0], now);
            }else{
                ArrayList<Option> newOne = new ArrayList<Option>();
                newOne.add(new Option(option2[0],option2[1],Integer.parseInt(option2[2])));
                options.put(option1[0], newOne);
            }
            if(options.containsKey(option2[0])){
                ArrayList<Option> now = options.get(option2[0]);
                now.add(new Option(option1[0], option2[1], Integer.parseInt(option2[2])));
                options.replace(option1[0], now);
            }else{
                ArrayList<Option> newOne = new ArrayList<Option>();
                newOne.add(new Option(option1[0], option2[1], Integer.parseInt(option2[2])));
                options.put(option2[0], newOne);
            }
        }
    }
    public static boolean isPossible(String target, String route){
        ArrayList<Option> al = options.get(target);
        int now = route.length();
        for(Option option : al){
            int tI = route.indexOf(option.target);
            if(tI == -1){
                continue;
            }
            String calc = option.fourth;
            if(calc.equals("<")){
                if(now - tI >= option.count+1){
                    return false;
                }
            }else if(calc.equals("=")){
                if(now - tI != option.count+1){
                    return false;
                }
            }else if(calc.equals(">")){
                if(now - tI <= option.count+1){
                    return false;
                }
            }
        }
        return true;
    }
    public static void find(int count, String now){
        if(count == 8){
            answer += 1;
            return;
        }
        for(int i = 0 ; i < 8; i++){
            if(!used[i]){
                if(!options.containsKey(characters[i])){
                    used[i] = true;
                    find(count+1, now + characters[i]);
                    used[i] = false;
                }else{
                    if(isPossible(characters[i], now)){
                        used[i] = true;
                        find(count+1, now + characters[i]);
                        used[i] = false;
                    }
                }
            }
        }
    }
    public static int solution(int n, String [] data){
        answer = 0;
        options = new LinkedHashMap<String, ArrayList<Option>>();
        used = new boolean[8];
        characters = new String [] {"A", "C", "F", "J", "M", "N", "R", "T"};
        setting(n,data);
        find(0,"");
        return answer;
    }
    public static void main(String[] args){
        int n = 2;
        String [] data = {"N~F=0", "R~T>2"};
        System.out.println(solution(n,data));
    }
}
