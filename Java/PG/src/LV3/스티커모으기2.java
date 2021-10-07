package LV3;

public class 스티커모으기2 {
    public static int solution(int [] sticker){
        int n = sticker.length;
        int [] dp = new int[n];
        int [] dp2 = new int [n];
        dp[0] = sticker[0]; dp[1] = sticker[0];
        dp2[1] = sticker[1];
        for(int i = 2; i < n-1; i++){
            dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);
            dp2[i] = Math.max(dp2[i-2]+sticker[i], dp2[i-1]);
        }
        int one = Math.max(dp[n-2], dp[n-3]);
        int two = Math.max(dp2[n-3]+sticker[n-1], dp2[n-2]);
        return Math.max(one, two);
    }
    public static void main(String[] args) {
        int [] sticker = new int [] {14, 6, 5, 11, 3, 9, 2, 10};
        System.out.println(solution(sticker));
    }
}
