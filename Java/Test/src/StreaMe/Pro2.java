package StreaMe;

import java.math.BigInteger;

public class Pro2 {
    public static BigInteger StoL(String S){
        BigInteger result = new BigInteger("0");
        int n = S.length();
        char now;
        for(int i = 0;i < n; i++){
            now = S.charAt(n-i-1);
            if(now == '1'){
                result.add(new BigInteger(String.valueOf(Math.pow(2, i))));
            }
        }
        long temps = Long.MAX_VALUE;
        return result;
    }
    public static int solution(String S){
//        BigInteger target = StoL(S);
        int answer = 0;
//        while(target.intValue() != 0){
//            if(target.remainder(new BigInteger("2")) == 0){
//                target /= 2;
//            }else{
//                target -= 1;
//            }
//            answer += 1;
//        }
        return answer;
    }
    public static void main(String[] args){
        String S = "011100";
//        System.out.println(solution(S));
//        S = "111";
//        System.out.println(solution(S));
//        S = "1111010101111";
//        System.out.println(solution(S));
        S = "";
        for(int i = 0; i < 400000; i++){
            S += "1";
        }
        System.out.println(solution(S));
    }
}
