package Devmat_Back_Late_Real;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Pro3 {
    static String [] keys;
    static Set<String> items;
    static int n;
    static int answer;
    public static String [] init(){
        String [] result = new String[3];
        for(int i = 0 ; i < 3; i++){
            String target;
            if(i == 0){
                target = "qwertyuio";
            }else if(i == 1){
                target = "pasdfghjk";
            }else{
                target = "lzxcvbnm ";
            }
            result[i] = target;
        }
        return result;
    }
    public static int calc(char now, char next){
        int now_x = -1, now_y = -1, next_x = -1, next_y = -1;
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 9; y++){
                char temps = keys[x].charAt(y);
                if(keys[x].charAt(y) == now){
                    now_x = x;
                    now_y = y;
                }else if(keys[x].charAt(y) == next){
                    next_x = x;
                    next_y = y;
                }
                if(now_x != -1 && now_y != -1 && next_x != -1 && next_y != -1){
                    break;
                }
            }
        }
        return(Math.abs(now_x - next_x) + Math.abs(now_y - next_y));
    }

    public static void recursive(char now, int count, int idx, String s, String route){
        if(idx == n-1){
            answer = (int)((answer+count) % (Math.pow(10, 9)+7));
            return;
        }
        int next_count;
        answer = (int)((answer+count) % (Math.pow(10, 9) + 7));
        char next = s.charAt(idx+1);
        if(next != now){
            next_count = (int)((count+calc(now, next))%(Math.pow(10, 9)+7));
        }else{
            next_count = count;
        }
        recursive(next, next_count, idx+1, s, route+next);
    }
    public static int solution(String s){
        answer = 0;
        keys = init();
        n = s.length();
        items = new LinkedHashSet<String>();
        for(int i = 0; i < n; i++){
            recursive(s.charAt(i), 0, i, s, String.valueOf(s.charAt(i)));
        }
        return answer;
    }
    public static void main(String[] args){
        String s = "abcc";
        System.out.println(solution(s));
    }
}
