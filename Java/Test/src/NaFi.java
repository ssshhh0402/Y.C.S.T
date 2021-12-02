import java.util.*;

public class NaFi{
    public static List<Integer> solution(int [] a, int d){
        int n = a.length;
        List<Integer> li = new ArrayList<Integer>();
        for(int i = 0 ;i < n; i++){
            if(i+d < n){
                li.add(a[i+d]);
            }else{
                li.add(a[i+d-n]);
            }
        }
        return li;
    }
    public static void main(String[] args){
        int [] a = new int [] {1,2,3,4,5};
        int n = 4;
        List<Integer>answers = solution(a, n);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}