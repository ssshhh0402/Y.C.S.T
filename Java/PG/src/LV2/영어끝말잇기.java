package LV2;

import java.util.ArrayList;

public class 영어끝말잇기 {
    public static int [] solution(int n, String [] words){
        ArrayList<String> al = new ArrayList<String>();
        int [] answer = new int[2];
        char before = ' ';
        int N = words.length;
        for(int i = 0; i < N; i++){
            if(i == 0){
                al.add(words[i]);
                before = words[i].charAt(words[i].length()-1);
            }else{
                String now = words[i];
                if(before == now.charAt(0) && !al.contains(now)){
                    al.add(now);
                    before = now.charAt(now.length()-1);
                }else{
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int n =3;
        String [] words = new String [] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int [] answers = solution(n, words);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
