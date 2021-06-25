import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Lesson4_1 {
    public static int solution(int X, int [] A){
        Set<Integer> base = new LinkedHashSet<Integer>();
        int answer = -1;
        for(int i = 0; i < A.length;i++){
            base.add(A[i]);
            if(base.size() == X){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(3, new int [] {2,1,1,2,1,2,1,1,2,1,2,1,2,3}));
//        System.out.println(solution(5,new int [] {1,3,1,4,2,3,5,4}));
//        System.out.println(solution(5, new int [] {1,2,4,3,1,2}));
//        System.out.println(solution(5,new int [] {1,3,4,2,2,1,3,5}));
//        System.out.println(solution(5, new int [] {1,2,3,4,5,3,2,4,1}));
    }
}
