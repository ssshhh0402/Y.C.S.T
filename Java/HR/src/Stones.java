import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stones {
    public static List<Integer> solution(int n, int a, int b){
        List<Integer> answer = new ArrayList<Integer>();
        for(int i = n-1; i >=0; i--){
            int now = a*i + b * (n-i-1);
            if(!answer.contains(now)){
                answer.add(now);
            }
        }
        Collections.sort(answer);
        return answer;
    }
    public static void main(String[] args){
        int n = 83;
        int a = 86;
        int b = 81;
        List<Integer> answers = solution(n,a,b);
        System.out.println(solution(n,a,b));
    }
}
