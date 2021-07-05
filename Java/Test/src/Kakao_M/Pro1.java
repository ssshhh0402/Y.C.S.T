package Kakao_M;

public class Pro1 {
    public static String solution(String S){
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        boolean flag = false;
        for(int i = 0 ; i < S.length(); i++){
            Character now = S.charAt(i);
            if(Character.isDigit(now)){
                sb.append(now);
            }
        }
        for(int i = 0; i < sb.length(); i++){
            Character now = sb.charAt(i);
            answer.append(now);
            if(i % 3 == 2 && i != sb.length()-1 && !flag){
                answer.append("-");
            }else if(i % 3 == 1 && i == sb.length()-3){
                answer.append("-");
                flag = true;
            }
        }
        return answer.toString();
    }
    public static void main(String[] args){
        String S = "00-44  48 5555 8361";
//        System.out.println(solution(S));
//        S = "0 - 22 1985--324";
//        System.out.println(solution(S));
//        S = "555-372-654";
//        System.out.println(solution(S));
        S = "32-  ";
        System.out.println(solution(S));
    }
}
