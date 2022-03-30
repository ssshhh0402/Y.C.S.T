package TodayHoust;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pro1 {
    public static Map<Integer, String> init(){
        Map<Integer, String> m = new LinkedHashMap<Integer, String>();
        m.put(0, "a");
        m.put(1, "b");
        m.put(2, "c");
        m.put(3, "d");
        return m;
    }
    public static int solution(String [][] rounds){
        int answer = 0;
        Map<Integer, String> index = init();
        Map<String, String> now, result;
        Map<String, String> before = new LinkedHashMap<String, String>();
        for(int i = 0; i < rounds.length; i++){
            now = new LinkedHashMap<String, String>();
            result = new LinkedHashMap<String, String>();
            for(int j = 0; j < 4; j++){
                String from = index.get(j), to = rounds[i][j];
                if(before.containsKey(from) && before.get(from).equals(to)){
                    answer += 1;
                }else if(from.equals(to)){
                    answer += 1;
                }else{
                    now.put(from, to);
                }
            }
            for(String key : now.keySet()){
                String target = now.get(key);
                if(now.containsKey(target) && now.get(target).equals(key)){
                    result.put(key, target);
                }
            }
            before = result;
        }
        return answer;
    }
    public static void main(String[] args){
        String [][] rounds = new String [][] {{"b", "a", "a", "d"}, {"b", "c", "a", "c"}, {"b", "a", "d", "c"}};
        System.out.println(solution(rounds));

        rounds = new String [][] {{"b", "a", "d", "c"},{"d", "c", "b", "a"},{"b", "a", "d", "c"}};

        System.out.println(solution(rounds));
        rounds = new String [][] {{"d", "a", "a", "a"},{"c", "a", "a", "a"},{"b", "a", "a", "a"}};

        System.out.println(solution(rounds));
        rounds = new String [][] {{"b", "a", "d", "c"},{"b", "a", "c", "d"}};
        System.out.println(solution(rounds));
    }
}
