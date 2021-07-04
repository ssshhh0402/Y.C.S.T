package NavWeb;

public class Pro3 {
    public static int solution(String s, String t){
        int answer = 0;
        while(s.contains(t)){
            s = s.replace(t, "");
            answer += 1;
        }
        return answer;
    }
    public static void main(String[] args){
        String s = "aabcbcd";
        String t = "abc";
        System.out.println(solution(s,t));
        s = "aaaaabbbbb";
        t = "ab";
        System.out.println(solution(s,t));
    }
}
