package Weekely;

public class FifthWeek {
    static int answer;
    static boolean flag;
    static String [] vowels = new String [] {"A","E","I","O","U"};
    public static void find(String now, String word){
        if(now.equals(word)){
            flag = true;
            return;
        }
        if(now.length() == 5){
            return;
        }
        for(int i = 0; i < 5; i++){
            if(!flag){
                answer += 1;
                find(now + vowels[i], word);
            }else{
                break;
            }
        }
    }
    public static int solution(String word){
        answer = 0;
        flag = false;
        for(int i = 0; i < 5; i++){
            if(!flag) {
                answer += 1;
                find(vowels[i],word);
            }else{
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String word = "AAAAE";
        System.out.println(solution(word));
        word = "AAAE";
        System.out.println(solution(word));
        word = "I";
        System.out.println(solution(word));
        word = "EIO";
        System.out.println(solution(word));
    }
}
