package Sk;

public class Pro1 {
    static int [] values = new int [] {1,5,10,50,100,500};
    static boolean [] used;
    public static int recursive(int cost, int money, int[] costs){
        if(money == 0){
            return cost;
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 6; i++){
            if(!used[i]){
                used[i]= true;
                int amount = money / values[i];
                int result = recursive(cost + costs[i] * amount, money % values[i], costs);
                answer = Math.min(result, answer);
                used[i] = false;
            }
        }
        return answer;
    }
    public static int solution(int money, int [] costs){
        int answer = Integer.MAX_VALUE;
        used = new boolean[6];
        for(int i = 0; i < 6; i++){
            int amount = money / values[i];
            used[i] = true;
            int result = recursive(costs[i] * amount, money % values[i], costs);
            answer=  Math.min(answer, result);
            used[i]= false;
        }
        return answer;
    }
    public static void main(String[] args){
        int money = 4578;
        int [] costs = new int [] {1, 4, 99, 35, 50, 1000};
        System.out.println(solution(money, costs));
    }
}
