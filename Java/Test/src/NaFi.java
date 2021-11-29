import java.util.*;

public class NaFi{
    public static List<Integer> solution(int [] a, int k, int [] queries){
        int n = a.length;
        List<Integer> answer = new ArrayList<Integer>();
        for(int query : queries){
            answer.add(a[(n-(n%k)+query)%n]);
        }
        return answer;
    }
    public static void main(String[] args){
        int [] a = new int [] {1,2,3};
        int n = 2;
        int [] queries = new int[] {0,1,2};
        List<Integer>answers = solution(a, n,queries);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}