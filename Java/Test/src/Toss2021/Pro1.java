package Toss2021;

public class Pro1 {
    public static long solution(long orderAmount, long taxFreeAmount, long serviceFee){
        long answer = 0;
        long result = (orderAmount - serviceFee - taxFreeAmount);
        if(result == 1){
            answer = 0;
        }else{
            double now = result * (double)0.1;

            answer = (long)(Math.ceil(result * 0.1));

        }
        return answer;
    }
    public static void main(String[] args){
        long orderAmount = 100;
        long taxFreeAmount = 0;
        long serviceFee = 0;
        System.out.println(solution(orderAmount,taxFreeAmount,serviceFee)); //10
        orderAmount = 120;
        taxFreeAmount = 20;
        serviceFee = 0;
        System.out.println(solution(orderAmount,taxFreeAmount,serviceFee)); //10
        orderAmount = 120;
        taxFreeAmount = 0;
        serviceFee = 20;
        System.out.println(solution(orderAmount,taxFreeAmount,serviceFee)); //10

    }
}
