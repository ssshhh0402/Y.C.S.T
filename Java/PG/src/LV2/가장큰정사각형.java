package LV2;

public class 가장큰정사각형 {
    public static int solution(int [][] board){
        int n = board.length;
        int m = board[0].length;
        int [][] dp = new int[n][m];
        int answer = -1;
        dp[0][0] = board[0][0];
        for(int i = 0; i < n; i++){
            if(board[i][0] == 1){
                dp[i][0] = 1;
            }
        }
        for(int i = 0; i < m; i++){
            if(board[0][i] == 1){
                dp[0][i] = 1;
            }
        }
        for(int x = 1; x < n; x++){
            for(int y = 1; y < m; y++){
                if(board[x][y] == 1){
                    dp[x][y] = Math.min(dp[x][y-1], Math.min(dp[x-1][y], dp[x-1][y-1]))+1;
                }
                answer = Math.max(answer, dp[x][y]);
            }
        }
        return answer * answer;
    }
    public static void main(String[] args){
        int [][] board = new int [][] {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        board = new int [][] {{0, 0, 1, 1}, {1, 1, 1, 1}};
        System.out.println(solution(board));
    }
}
