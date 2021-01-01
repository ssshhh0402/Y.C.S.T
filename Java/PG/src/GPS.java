import java.util.ArrayList;
import java.util.Arrays;

public class GPS {
    public static int solution(int n, int m, int [][] edge_list, int k, int [] gps_log){
        int answer = 0;
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
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution());
    }
}

