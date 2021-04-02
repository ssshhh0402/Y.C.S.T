import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ForTest {
    public static int find(int [][] v, int idx){
        int answer = 0;
        Map<Integer,Integer> count = new LinkedHashMap<Integer,Integer>();
        for(int [] items : v){
            if(count.containsKey(items[idx])){
                count.replace(items[idx], count.get(items[idx]) + 1);
            }else{
                count.put(items[idx], 1);
            }
        }
        for(Integer item : count.keySet()){
            if(count.get(item) == 1){
                answer = item;
                break;
            }
        }
        return answer;
    }
    public static int [] solution(int [][] v){
        int [] answer = new int[2];
        for(int i = 0; i < 2; i++){
            answer[i] = find(v, i);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        int [] answer = solution(new int [][] {{1,4},{3,4},{3,10}});
        for(int value : answer){
            System.out.println(value);
        }
        answer = solution(new int [][] {{1,1},{2,2},{1,2}});
        for(int value : answer){
            System.out.println(value);
        }
    }
}
