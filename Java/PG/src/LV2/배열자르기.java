package LV2;

public class 배열자르기 {
    public static int [] solution(int n, long left, long right){
        int [] answer = new int[(int)(right-left+1)];
        for(long i = left; i <= right; i++){
            answer[(int)(i-left)] = (int)(Math.max((i / n) , (i % n)))+1;
        }

        return answer;
    }
    public static void main(String[] args){
        int n = 3;
        long left = 2;
        long right = 5;
        int [] answers = solution(n,left,right);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
