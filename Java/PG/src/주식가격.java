public class 주식가격 {
    public static int [] solution(int [] prices){
        int [] answer = {};
        int n = prices.length;
        answer = new int[n];
        int count;
        for(int i = 0 ; i < n; i++){
            int target = prices[i];
            count = 0;
            for(int j = i+1; j < n; j++){
                count += 1;
                if(prices[j] <target){
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
    public static void main(String[] args){
        int [] answers = solution(new int[] {1,2,3,2,3});
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
