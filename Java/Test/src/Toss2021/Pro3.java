package Toss2021;

public class Pro3 {
    public static boolean stepOne(String money){
        for(int i = 0; i < money.length(); i++){
            Character now = money.charAt(i);
            if(!Character.isDigit(now) && now != ','){
                return false;
            }
        }
        return true;
    }
    public static boolean stepTwo(String money){
        if(money.charAt(0) == '0' && Integer.parseInt(money) != 0){
            return false;
        }else{
            return true;
        }
    }
    public static boolean stepThree(String money){
        if(money.contains(",")){
            int n = money.length();
            for(int i = 0; i < n; i++){
                if(money.charAt(i) == ','){
                    if(i == 0 || i == (n-1) || (n-i) % 4 != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean solution(String amountText){
        boolean answer = true;
        if(stepOne(amountText)){
            if(stepTwo(amountText)){
                if(!stepThree(amountText)){
                    answer = false;
                }
            }else{
                answer = false;
            }
        }else{
            answer=  false;
        }
        return answer;
    }
    public static void main(String[] args){
        String amountText = "10000";
//        System.out.println(solution(amountText));
//        amountText = "25,000";
//        System.out.println(solution(amountText));
        amountText = "39,00";
        System.out.println(solution(amountText));
        amountText = "3";
        System.out.println(solution(amountText));
    }
}
