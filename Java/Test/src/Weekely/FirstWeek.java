package Weekely;

public class FirstWeek {
    public static long solution(int price, int money, int count){
        long answer = -1;
        long sum = 0;
        for(int i = 1; i < count+1; i++){
            sum += price * (i);
        }
        if(sum < money){
            answer = 0;
        }else{
            answer = sum - money;
        }
        return answer;
    }
    public static void main(String[] args){
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(solution(price,money,count));
    }
}
