package NaverWebtoon;

public class Pro1 {
    static int [] dp;
    static int answer, target, limit;
    public static boolean isPos(int money, int idx,int K){
        int result = dp[idx-1] + money;
        if(idx - limit >= 0){
            result -= dp[idx-limit];
        }
        if(result <= K){
            return true;
        }else{
            return false;
        }
    }
    public static void find(int count, int money, int K){
        if(count == dp.length){
            if(money == 0){
                answer +=1;
            }
            return;
        }
        for(int i = 1; i < money+1; i++){
            if(isPos(i,count,K)){
                dp[count] = dp[count-1] + i;
                find(count+1, money - i, K);
                dp[count] = 0;
            }else{
                break;
            }
        }
    }
    public static int solution(int N, int money, int T, int K){ //N = ATM 숫자, money= 돈, T = 연속 Atm 갯수, K = 연속 ATM 돈 제한
        answer = 0;
        limit = T;
        dp = new int[N];
        target = money;
        for(int i = 1; i < money+1; i++){
            if(i <= K){
                dp[0] = i;
                find(1, money - i, K);
            }else{
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int N = 2;
        int money = 4;
        int T = 1;
        int K = 3;
        System.out.println(solution(N,money, T, K));
        N = 4;
        money = 7;
        T = 2;
        K = 4;
        System.out.println(solution(N,money, T, K));
        N = 4;
        money = 7;
        T = 2;
        K = 3;
        System.out.println(solution(N,money,T,K));
    }
}
