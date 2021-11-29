package Beat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro3 {
    public static int solution(int[] numbers){
        int n = numbers.length;
        int [][] dp = new int[n][n];

        int answer = 0;
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], n+1);
            for(int j = 0; j < n; j++){
                if(i != j && numbers[i] <= numbers[j]){
                    dp[i][j] = 1;
                }
            }
        }
        for(int z = 0; z < n; z++){
            for(int x = 0; x < n; x++){
                for(int y = 0; y < n; y++){
                    if(dp[x][y] > dp[x][z] + dp[z][y]){
                        dp[x][y] = dp[x][z] + dp[z][y];
                    }
                }
            }
        }
        for(int x = 0; x < n; x++){
            if(dp[x][x] != Integer.MAX_VALUE){
                answer += dp[x][x];
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] numbers = new int[] {2,0,1,2};
        System.out.println(solution(numbers));
    }
}
