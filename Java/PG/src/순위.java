import java.io.IOException;
import java.util.Arrays;

public class 순위 {
    public static int solution(int n, int [][] results){
        int answer = 0;
        int min = 5000;
        int [][] dp = new int [n+1][n+1];
        for(int x = 0; x < n+1; x++){
            Arrays.fill(dp[x], min);
        }
        for(int [] result : results){
            dp[result[0]][result[1]] = 1;
        }
        for(int z = 1; z < n+1; z++){
            for(int x = 1; x < n+1; x++){
                for(int y = 1; y < n+1; y++){
                    if(dp[x][y] > dp[x][z] + dp[z][y]){
                        dp[x][y] = dp[x][z] + dp[z][y];
                    }
                }
            }
        }
        for(int x = 1; x < n+1; x++){
            boolean flag = true;
            for(int y = 1; y < n+1; y++){
                if(x == y){
                    continue;
                }
                if( dp[x][y] == min && dp[y][x] == min){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer += 1;
            }
        }
        return answer;

    }
    public static void main(String[] args) throws IOException{
        System.out.println(solution(5, new int [][] {{4,3},{4,2},{3,2},{1,2},{2,5}}));
    }
}
