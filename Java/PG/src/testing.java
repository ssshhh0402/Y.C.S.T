import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class testing {
    public static int find(int [][] v, int target){
        Map<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
        for(int [] item : v){
            if(m.containsKey(item[target])){
                m.replace(item[target], m.get(item[target])+1);
            }else{
                m.put(item[target], 1);
            }
        }
        int answer = 0;
        for(int key : m.keySet()){
            if(m.get(key) == 1){
                answer = key;
                break;
            }
        }
        return answer;
    }
    public static int[] solution(int [][] v){
        int [] answer = new int[2];
        for(int i = 0; i < 2; i++){
            answer[i] = find(v, i);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        int [] answers = solution(new int [][] {{1,4},{3,4},{3,10}});
    }
}
