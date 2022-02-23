import java.util.ArrayList;
import java.util.List;

public class SubArrayDivision {
    public static int birthday(List<Integer> s, int d, int m){
        int n = s.size();
        int answer = 0;
        int [] dp = new int[n+1];
        if(s.size() == 1 && s.get(0) == d){
            return 1;
        }

        for(int i = 1; i < n+1; i++){
            dp[i] = dp[i-1] + s.get(i-1);
            if(i - m >= 0){
                int target = dp[i] - dp[i-m];
                if(target == d){
                    answer += 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] S = new int [] {4, 5, 4, 2, 4, 5, 2, 3, 2, 1, 1, 5, 4};
        List<Integer> s = new ArrayList<Integer>();
        int d = 15;
        int m = 4;
        for(int ss : S){
            s.add(ss);
        }
        System.out.println(birthday(s, d, m));
    }
}
