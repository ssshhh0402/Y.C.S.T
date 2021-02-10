import java.util.ArrayList;
import java.util.HashSet;

public class 소수찾기 {
    static HashSet<Integer> used = new HashSet<Integer>();
    static int n;
    static boolean [] visited;
    static String [] items;
    public static boolean isPrime(int target){
        if(target < 2){
            return false;
        }else if(target == 2){
            return true;
        }
        for(int i = 2 ; i < Math.sqrt(target)+1; i++){
            if(target % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void find(String target){
        int N = Integer.parseInt(target);
        if(isPrime(N)){
            used.add(N);
        }
        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                find(target+items[i]);
                visited[i] = false;
            }
        }
    }
    public static int solution(String numbers){
        n = numbers.length();
        visited = new boolean[n];
        items = numbers.split("");
        for(int i = 0 ; i < items.length; i++){
            visited[i] = true;
            find(items[i]);
            visited[i] = false;
        }
        return used.size();
    }
    public static void main(String[] args){
        //System.out.println(solution("17"));
//        System.out.println(solution("011"));
        System.out.println(solution("2"));
    }
}
