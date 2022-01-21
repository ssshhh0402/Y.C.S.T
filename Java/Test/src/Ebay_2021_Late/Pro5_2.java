package Ebay_2021_Late;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Pro5_2 {
    static ArrayList<String> al;
    static boolean [] removed;
    static Set<String> st;
    static int n;
    public static boolean isPellindrom(String target){
        int m = target.length();
        for(int i = 0; i < m / 2; i++){
            if(target.charAt(i) != target.charAt(m-i-1)){
                return false;
            }
        }
        return true;
    }
    public static Set<String> init(String[] P){
        Set<String> st = new LinkedHashSet<String>();
        for(int i = 0 ; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(isPellindrom(P[i]+P[j])){
                    st.add(P[i]+P[j]);
                }
                if(isPellindrom(P[j]+P[i])){
                    st.add(P[j]+P[i]);
                }
            }
        }
        return st;
    }
    public static boolean recursive(String start, int count, String[] P){
        if(count == n){
            return true;
        }
        for(int i = 1; i < n; i++){
            if(!removed[i]){
                removed[i] = true;
                for(int j = 1; j < n; j++){
                    if(!removed[j]){
                        if(st.contains(P[i]+P[j]) || st.contains(P[j]+P[i])){
                            removed[j] = true;
                            boolean result = recursive(start, count+2, P);
                            removed[j] = false;
                            if(result){
                                removed[i] = false;
                                return true;
                            }
                        }
                    }
                }
                removed[i] = false;
            }
        }
        return false;
    }
    public static String[] solution(String[] P){
        al = new ArrayList<String>();
        n = P.length;
        removed = new boolean[n];
        removed[0] = true;
        st = init(P);
        for(int i = 1; i < n; i++){
            if(st.contains(P[0]+P[i]) || st.contains(P[i]+P[0])){
                removed[i] = true;
                boolean result = recursive(P[i], 2, P);
                removed[i] = false;
                if(result){
                    al.add(P[i]);
                }
            }
        }
        String[] answer = new String[al.size()];
        for(int i = 0 ; i < al.size(); i++){
            answer[i] = al.get(i);
        }
        return answer;
    }
    public static void main(String [] args){
        String [] P = new String [] {"11","111","11","211"};
        String [] answers = solution(P);
        for(String answer : answers){
            System.out.println(answer);
        }
    }
}
