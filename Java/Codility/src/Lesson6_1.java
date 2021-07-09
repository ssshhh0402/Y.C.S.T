import java.util.LinkedHashMap;
import java.util.Map;

public class Lesson6_1 {
    public static int solution(int [] A){
        Map<Integer, Boolean> m = new LinkedHashMap<Integer, Boolean>();
        int count = 0;
        for(int a : A){
            if(!m.containsKey(a)){
                count += 1;
                m.put(a, true);
            }
        }
        return count;
    }
    public static void main(String[] args){
        int [] A = new int [] {2,1,1,2,3,1};
        System.out.println(solution(A));
    }
}
