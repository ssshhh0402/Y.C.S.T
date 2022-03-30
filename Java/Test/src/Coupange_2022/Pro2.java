package Coupange_2022;


public class Pro2 {
    static int answer;
    public static int getCount(int [] rooms, int roomNum, int roomValue){
        int n = rooms.length;
        int result = Integer.MAX_VALUE;
        int now, next, open;
        boolean [] opened;
        for(int i = 0; i < n; i++){
            now = i;
            open = 1;                                   //열린 방 개수
            opened = new boolean[n];
            opened[i] = true;
            while(true){
                if(now == roomNum){
                    next = roomValue;
                }else{
                    next = rooms[now]-1;
                }
                if(!opened[next]){
                    opened[next] = true;
                    open += 1;
                    now = next;
                }else{
                    break;
                }
            }
            if(open == n){
                result = 1;
            }else{
                result = Math.min(result, n-open);
            }
        }
        return result;
    }
    public static int solution(int [] rooms){
        int answer = Integer.MAX_VALUE;
        int n = rooms.length;
        int count;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                count = getCount(rooms,i,j);
                answer = Math.min(answer, count);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] rooms = new int [] {3,1,2,4};
        System.out.println(solution(rooms));
    }
}
