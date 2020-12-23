import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class 보석쇼핑 {
    public static int find(ArrayList<String> words){
        ArrayList<String> finds = new ArrayList<String>();
        for(String word : words){
            if (!finds.contains(word)){
                finds.add(word);
            }
        }
        return finds.size();
    }
    public static int[] solution(String[] gems){
        int [] answer= {};
        int s = 0, e = 0;
        int answer_s = 0, answer_e = gems.length;
        HashSet<String> base = new HashSet<String>();
        ArrayList<String> comp = new ArrayList<String>();
        Collections.addAll(base,gems);
        while(s < gems.length) {
            if(e - s + 1 > answer_e - answer_s || e == gems.length){
                comp.remove(gems[s]);
                s += 1;
            }else{
                comp.add(gems[e]);
                e += 1;
            }
            int N = find(comp);
            if(N == base.size()){
                if(e - s < answer_e - answer_s){
                    answer_e = e;
                    answer_s = s;
                }else if(e-s == answer_e - answer_s && s < answer_s){
                    answer_s = s;
                }
            }
        }
        answer = new int[2];
        answer[0] = answer_s + 1;
        answer[1] = answer_e;
        return answer;
    }
    public static void main(String[] args){
        int [] answer = solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        System.out.println("시작 : " + String.valueOf(answer[0]) + ", 끝 : " + String.valueOf(answer[1]));
        answer = solution(new String[] {"AA", "AB", "AC", "AA", "AC"});
        System.out.println("시작 : " + String.valueOf(answer[0]) + ", 끝 : " + String.valueOf(answer[1]));
        answer = solution(new String[] {"XYZ", "XYZ", "XYZ"});
        System.out.println("시작 : " + String.valueOf(answer[0]) + ", 끝 : " + String.valueOf(answer[1]));
        answer = solution(new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
        System.out.println("시작 : " + String.valueOf(answer[0]) + ", 끝 : " + String.valueOf(answer[1]));
        answer = solution(new String[] {"a", "b", "a", "b", "c"});
        System.out.println("시작 : " + String.valueOf(answer[0]) + ", 끝 : " + String.valueOf(answer[1]));

    }
}
