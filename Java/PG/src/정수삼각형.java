public class 정수삼각형 {
    public static int solution(int [][] triangles){
        int n = triangles.length;
        int [][] dp = new int[n][];
        for(int i = 0; i < n;i++){
            dp[i] = new int[i+1];
        }
        dp[0][0] = triangles[0][0];
        for(int x = 1; x < n; x++){
            for(int y = 0; y < x+1;y++){
                if(y == 0){
                    dp[x][y] = dp[x-1][y] + triangles[x][y];
                }else if(y == x){
                    dp[x][y] = dp[x-1][y-1] + triangles[x][y];
                }else{
                    dp[x][y] = Math.max(dp[x-1][y-1], dp[x-1][y]) + triangles[x][y];
                }
            }
        }
        int answer = 0;
        for(int y = 0; y < n;y++){
            answer = Math.max(dp[n-1][y], answer);
        }
        return answer;
    }
    public static void main(String[] args){
        int [][] triangles = new int[][] {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(solution(triangles));

    }
}
