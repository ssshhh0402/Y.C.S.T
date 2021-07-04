package NavWeb;

import java.util.Arrays;


public class Pro1 {
    public static int solution(int [] prices , int [] discounts){

        Arrays.sort(prices);
        Arrays.sort(discounts);
        int answer = 0;
        int n = prices.length, m = discounts.length;
        for(int i = 0; i < n; i++){
            int price = prices[n-i-1];
            if(i < m){
                int discount = discounts[m-i-1];
                answer += (int)(price - (price * (double)(discount)*0.01));
            }else{
                answer += price;
            }
        }
//        int answer = 0;
//        for(int price : prices){
//            pq.add(price);
//        }
//        for(int discount : discounts){
//            dq.add(discount);
//        }
//        while(!pq.isEmpty() && !dq.isEmpty()){
//            int price = pq.poll();
//            int discount = dq.poll();
//            answer += (int)(price - (price * (double)(discount)*0.01));
//        }
//        while(!pq.isEmpty()){
//            int price = pq.poll();
//            answer += price;
//        }
        return answer;
    }
    public static void main(String[] args){
        int [] prices = new int []{13000,88000,10000};
        int [] discounts = new int [] {30,20};
        System.out.println(solution(prices, discounts));
        prices = new int [] {18000,32000,42500};
        discounts = new int [] {50,20,65};
        System.out.println(solution(prices, discounts));
    }
}
