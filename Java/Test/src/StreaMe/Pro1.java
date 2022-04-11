package StreaMe;

public class Pro1 {
    public static boolean solution(String S){
        int n = S.length();
        boolean flag = true;
        int idx = 0;
//        while(idx < n){
//            char now = S.charAt(idx);
//            if(now == 'a' && !flag){
//                break;
//            }else if(now == 'b'){
//                flag = false;
//            }
//            idx += 1;
//        }
        int i;
        for(i = 0; i < n; i++){
            char now = S.charAt(i);
            if(now == 'a' && !flag){
                break;
            }else if(now == 'b'){
                flag = false;
            }
        }
        return i == n;
    }
    public static void main(String[] args){
        String S = "aabbb";
        System.out.println(solution(S));
        S = "ba";
        System.out.println(solution(S));
        S = "ab";
        System.out.println(solution(S));
        S = "b";
        System.out.println(solution(S));
        S = "abba";
        System.out.println(solution(S));
    }
}
