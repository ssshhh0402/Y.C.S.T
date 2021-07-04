package NavWeb;

import java.util.ArrayList;
import java.util.List;

public class Pro2 {
    static int temps;
    static List<String> answer;
    static int N;
    public static void find(int idx, ArrayList<String> routes,String s, int counts){
        if(idx >= (N/2)){
            if(temps < counts){
                temps = counts;
                answer = List.copyOf(routes);
            }
            return;
        }
        int count = 0;
        while(idx + count < N){
            String one = s.substring(idx, idx+count+1);
            String two = s.substring(N-count-idx-1, N-idx);
            if(one.equals(two)){
                if(idx != N-count-idx-1) {
                    routes.add(one);
                    find(idx + count + 1, routes, s, counts + 2);
                    routes.remove(routes.size() - 1);
                }else{
                    routes.add(one);
                    find(idx+count+1, routes, s, counts + 1);
                }
            }
            count += 1;
        }
    }
    public static String[] solution(String s){
        temps = 0;
        answer = new ArrayList<String>();
        N = s.length();
        for(int i = 0; i< N; i++){
            String one = s.substring(0,i+1);
            String two = s.substring(N-i-1, N);
            if(one.equals(two)){
                ArrayList<String> now = new ArrayList<String>();
                now.add(one);
                if(0 == (N-i-1)){
                    find(i+1, now, s, 1);
                }else {
                    find(i + 1, now, s, 2);
                }
            }
        }
        int M = answer.size();
        String [] returns;
        if(temps % 2 == 0){
            returns = new String[2 * M];
            for(int i = 0 ; i < M; i++){
                returns[i] = answer.get(i);
                returns[2 * M - i - 1] = answer.get(i);
            }
        }else{
            returns = new String[2 * M - 1];
            for(int i = 0; i < M; i++){
                if(i == (M-1)){
                    returns[i] = answer.get(i);
                }else {
                    returns[i] = answer.get(i);
                    returns[2 * M - i - 2] = answer.get(i);
                }
            }
        }
        return returns;
    }
    public static void main(String[] args){
        String s  = "abcxyasdfasdfxyabc";
        String[] answers = solution(s);
        for(String answer : answers){
            System.out.print(answer+" ");
        }
        System.out.println("");
        s  = "abcxyqwertyxyabc";
        answers = solution(s);
        for(String answer : answers){
            System.out.print(answer + " ");
        }
        System.out.println("");
        s  = "abcabcabcabc";
        answers = solution(s);
        for(String answer : answers){
            System.out.print(answer + " ");
        }
        System.out.println("");
        s  = "llttaattll";
        answers = solution(s);
        for(String answer : answers){
            System.out.print(answer + " ");
        }
        System.out.println("");
        s  = "zzzzzz";
        answers = solution(s);
        for(String answer : answers){
            System.out.print(answer + " ");
        }
        System.out.println("");
        s = "abcdef";
        answers = solution(s);
        for(String answer : answers){
            System.out.print(answer);
        }
        System.out.println("");
    }
}
