import java.util.ArrayList;
import java.util.Arrays;

public class GPS {
    public static int solution(int n, int m, int [][] edge_list, int k, int [] gps_log){
        ArrayList<Integer>[] base = new ArrayList[n+1];
        for(int i = 0 ; i < n+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        int [][] dp = new int[k][n+1];
        for(int i = 0 ; i < edge_list.length; i++){
            int start = edge_list[i][0];
            int end = edge_list[i][1];
            base[start].add(end);
            base[end].add(start);
        }
        for(int i = 0 ; i < k; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][gps_log[0]] = 0;
        for(int i = 1; i < k; i++){
            for(int j = 1; j < n+1; j++){
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                for(int toGo : base[j]){
                    dp[i][j] = Math.min(dp[i-1][toGo], dp[i][j]);
                }
                if(gps_log[i] != j){
                    if(dp[i][j] != Integer.MAX_VALUE){
                        dp[i][j] += 1;
                    }
                }
            }
        }
        int answer = dp[k-1][gps_log[k-1]];
        if(answer == Integer.MAX_VALUE){
            return -1;
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        System.out.println('1');

    }
}

