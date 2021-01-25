public class Pro4 {

    public static int ways(int total, int k){
        int [] dp = new int [total+1];
        dp[0] = 1;
        for(int i = 0; i < k; i++){
            int target = i + 1;
            for(int j = 1; j < total+1; j++){
                if(j - target >= 0){
                    dp[j] += dp[j-target];
                }
            }
        }
        return dp[total];
    }
    public static void main(String[] argh){
        System.out.println(ways(8,2));
    }
}
