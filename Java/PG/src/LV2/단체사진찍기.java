package LV2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class 단체사진찍기 {
    static int answer;
    static String[] characters;
    static boolean [] used;
    public static boolean isPossible(String line, String [] data){
        for(String rule : data){
            char target = rule.charAt(0);
            char target2 = rule.charAt(2);
            char oper = rule.charAt(3);
            int diff = (rule.charAt(4) - '0')+1;
            int now = Math.abs(line.indexOf(target2) - line.indexOf(target));
            if(oper == '='){
                if(now != diff) {
                    return false;
                }
            }else if(oper == '<'){
                if(now >= diff){
                    return false;
                }
            }else if(oper == '>'){
                if(now <= diff){
                    return false;
                }
            }
        }
        return true;
    }
    public static void find(int count, String line, String [] data){
        if(count == 8){
            if(isPossible(line, data)){
                answer += 1;
            }
            return;
        }
        for(int i = 0 ; i < 8; i++){
            if(!used[i]){
                used[i] = true;
                find(count+1, line +characters[i], data);
                used[i] = false;
            }
        }
    }
    public static int solution(int n, String [] data){
        answer = 0;
        characters = new String [] {"A","C","F","J","M","N","R","T"};
        used = new boolean[8];
        for(int i = 0; i < 8; i++){
            used[i] = true;
            find(1, characters[i], data);
            used[i] = false;
        }
        return answer;
    }
    public static void main(String[] args){
        int n = 2;
        String [] data = {"N~F=0", "R~T>2"};
        System.out.println(solution(n,data));
    }
}
