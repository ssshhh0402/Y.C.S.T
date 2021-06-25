import java.util.LinkedHashMap;
import java.util.Map;

public class Lesson2_2 {
    public static int solution(int [] A){
        Map<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
        int answer = 0;
        for(int a : A){
            if(m.containsKey(a)){
                m.replace(a, m.get(a)+1);
            }else{
                m.put(a, 1);
            }
        }
        for(int i : m.keySet()){
            if(m.get(i) % 2 != 0){
                answer =  i;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(new int [] {9,3,9,3,9,7,9}));
    }
}
