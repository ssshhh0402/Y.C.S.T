package Toss2021;

public class Pro4 {
    public static String solution(String input){
        String [] inputs = input.split("\n");
        for(String inputa : inputs){
            System.out.println(inputa);
        }
        return "I";
    }
    public static void main(String[] args){
        String input= "1 3\\nSHOW\\nNEXT\\nEXIT";
        System.out.println(solution(input));
    }
}
