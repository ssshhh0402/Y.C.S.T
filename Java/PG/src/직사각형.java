import java.util.LinkedHashMap;
import java.util.Map;

public class 직사각형 {
    static Map<Integer, Integer> base;
    public static int findX(int [][] v){
        int answer = 0;
        base = new LinkedHashMap<Integer,Integer>();
        for(int [] item : v){
            if(base.containsKey(item[0])){
                base.replace(item[0], base.get(item[0])+1);
            }else{
                base.put(item[0], 1);
            }
        }
        for(int key : base.keySet()){
            if(base.get(key) == 1){
                answer = key;
                break;
            }
        }
        return answer;
    }
    public static int findY(int [][] v){
        int answer = 0;
        base = new LinkedHashMap<Integer, Integer>();
        for(int [] item : v){
            if(base.containsKey(item[1])){
                base.replace(item[1], base.get(item[1])+1);
            }else{
                base.put(item[1], 1);
            }
        }
        for(int key : base.keySet()){
            if(base.get(key) == 1){
                answer = key;
                break;
            }
        }
        return answer;
    }
    public static int [] solution(int [][] v){
        int [] answer = {};
        answer = new int[2];
        answer[0] = findX(v);
        answer[1] = findY(v);
        return answer;
    }
    public static void main(String[] args) {
        int [] answers = solution(new int [][] {{1,4},{3,4},{3,10}});
        for(int answer : answers){
            System.out.println(answer);
        }
        answers = solution(new int [][] {{1,1},{2,2},{1,2}});
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
