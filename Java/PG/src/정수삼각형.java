public class 정수삼각형 {
    public static int solution(int [][] triangle){
        int answer = 0;
        int n = triangle.length;
        int [][] dp = new int [n][];
        for(int i = 0; i < n; i++){
            dp[i] = new int[i+1];
        }
        for(int x = 0 ; x < n; x++){
            for(int y = 0; y < x+1; y++){
                if(x == 0){
                    dp[x][y] = triangle[x][y];
                }else{
                    if(y == 0){
                        dp[x][y] = dp[x-1][y] + triangle[x][y];
                    }else if(x == y){
                        dp[x][y] = dp[x-1][y-1] + triangle[x][y];
                    }else{
                        dp[x][y] = Math.max(dp[x-1][y-1], dp[x-1][y]) + triangle[x][y];
                    }
                }
            }
        }
        for(int i = 0 ; i < n; i++){
            answer = Math.max(answer, dp[n-1][i]);
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(new int [][] {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}}));
    }
}
