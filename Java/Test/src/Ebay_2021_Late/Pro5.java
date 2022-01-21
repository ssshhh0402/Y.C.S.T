package Ebay_2021_Late;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Pro5 {
    static ArrayList<String> al;
    static Set<String> st;
    static int n;
    static boolean [] removed;
    public static boolean isPellindrom(String target){
        int m = target.length();
        for(int i = 0; i < (m / 2); i++){
            if(target.charAt(i) != target.charAt(m-i-1)){
                return false;
            }
        }
        return true;
    }
    public static void recursive(String start, int count, String[] P){
        if(count == n){
            if(!al.contains(start)){
                al.add(start);
            }
            return;
        }
        for(int i = 1; i < n; i++){
            if(!removed[i]){
                removed[i] = true;
                for(int j = 1; j < n; j++){
                    if(!removed[j]){
                        if(isPellindrom(P[i]+P[j]) || isPellindrom(P[j]+P[i])){
                            removed[j] = true;
                            recursive(start, count+2, P);
                            removed[j] = false;

                        }
                    }
                }
                removed[i] = false;
            }
        }
    }
    public static String[] solution(String [] P){
        al = new ArrayList<String>();
        st = new LinkedHashSet<String>();
        n = P.length;
        removed = new boolean[n];
        removed[0] = true;
        for(int i = 1; i < n; i++){
            if(st.contains(P[0]+P[i]) || st.contains(P[i]+P[0])){
                removed[i] = true;
                recursive(P[i], 2, P);
                removed[i] = false;
            }else{
                if(isPellindrom(P[i]+P[0])){
                    st.add(P[0]+P[i]);
                    removed[i] = true;
                    recursive(P[i], 2, P);
                    removed[i] = false;
                }
                if(isPellindrom(P[i] + P[0])){
                    st.add(P[i]+P[0]);
                    removed[i] = true;
                    recursive(P[i], 2, P);
                    removed[i] = false;
                }
            }
        }
        String [] answer = new String[al.size()];
        for(int i = 0; i < al.size(); i++){
            answer[i] = al.get(i);
        }
        return answer;
    }
    public static void main(String[] args){
        String [] P = new String [] {"11","111","11","211"};
        String [] answers = solution(P);
        for(String answer : answers){
            System.out.println(answer);
        }
    }
}
