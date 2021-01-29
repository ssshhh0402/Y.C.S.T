import java.util.HashMap;

public class 호텔방배정 {
    static HashMap<Long, Long> base;
    public static long find(long start) {
        if(!base.containsKey(start)){
            base.put(start, start+1);
            return start;
        }
        long target = find(base.get(start));
        base.put(start, target);
        return target;
    }
    public static long [] solution(long k, long[] room_number){
        base = new HashMap<Long,Long>();
        int n = room_number.length;
        long[] answer = new long[room_number.length];
        for(int i = 0; i < n; i++){
            answer[i] = find(room_number[i]);
        }
        return answer;
    }
    public static void main(String[] args){
        long [] items = solution(10, new long [] {1,3,4,1,3,1});
        for(long item : items){
            System.out.println(item);
        }
    }
}
