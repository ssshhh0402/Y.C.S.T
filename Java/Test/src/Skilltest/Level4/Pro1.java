package Skilltest.Level4;

public class Pro1 {
    static int answer;
    static int [][][] dp;
    public static int recursive(int flag, int start, int end){
        if(start == end){
            return flag;
        }
        return flag;
    }
    public static int solution(String[] arr){
        int n = arr.length;
        dp = new int [2][n][n];
        return recursive(0,0,n);
    }
    public static void main(String[] args){
        String [] arr = new String [] {"1", "-", "3", "+", "5", "-", "8"};
        System.out.println(solution(arr));
    }
}
