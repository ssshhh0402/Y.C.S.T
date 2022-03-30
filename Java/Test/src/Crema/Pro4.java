package Crema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro4 {
    public static int solution(List<Integer> locations){
        int n = locations.size();
        int [] dp = new int[n];
        for(int i = 0; i < n; i++){
            int left = Math.max(i - locations.get(i), 0);
            int right = Math.min(i+locations.get(i)+1, 0);
            dp[left] = Math.max(dp[left], right);
        }
        int answer = 1;
        int right = dp[0];
        int next = dp[0];
        for (int i = 0; i < n; i++)
        {
            next = Math.max(next, dp[i]);
            if (i == right && dp[i] != 0)
            {
                answer++;
                right = next;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] L = new int [] {2,0,0,0};
        L = new int [] {1,1,1};
        List<Integer> locations = new ArrayList<Integer>();
        for(int l : L){
            locations.add(l);
        }
        System.out.println(solution(locations));
    }
}
