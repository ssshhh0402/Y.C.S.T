package LV3;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class 뉴스클러스터링 {
    public static ArrayList<String> getSet(String str){
        ArrayList<String> set = new ArrayList<String>();
        int n = str.length();
        String word = "";
        for(int i = 0; i < n; i++){
            Character now = str.charAt(i);
            if(Character.isAlphabetic(now)){
                word += Character.toLowerCase(now);
            }else{
                word = "";
            }
            if(word.length() == 2){
                set.add(word);
                word = String.valueOf(Character.toLowerCase(str.charAt(i)));
            }
        }
        return set;
    }
    public static int solution(String str1, String str2){
        ArrayList<String> commons = new ArrayList<String>();
        ArrayList<String> everything = new ArrayList<String>();
        ArrayList<String> str1s = getSet(str1);
        ArrayList<String> str2s = getSet(str2);
        boolean [] used = new boolean[str2s.size()];
        int n, m;
        if(str1s.size() == 0 && str2s.size() == 0){
            n = 1;
            m = 1;
        }else {
            for (String str : str1s) {
                for(int i = 0 ; i < str2s.size(); i++){
                    if(!used[i] && str.equals(str2s.get(i))){
                        used[i] = true;
                        commons.add(str);
                        break;
                    }
                }
                everything.add(str);
            }
            for(int i = 0; i < str2s.size(); i++){
                if(!used[i]){
                    everything.add(str2s.get(i));
                }
            }

            n = commons.size();
            m = everything.size();
        }
        double answer = (double)n / (double)m;
        return (int)(answer * 65536);
    }
    public static void main(String[] args){
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(solution(str1, str2));
    }
}
