package Coupange_2022;

public class Pro2_2 {
    static int answer, n;
    static boolean [] opened;
    public static void recursive(int now, int masterKeyCount, int openRoomCount, boolean changed, int [] rooms){
        if(openRoomCount == n){
            answer = Math.min(masterKeyCount, answer);
            return;
        }
        if(!opened[now]){
            opened[now] = true;
            recursive(rooms[now]-1, masterKeyCount, openRoomCount+1, changed, rooms);
            opened[now] = false;
            return;
        }
        if(!changed) {
            for (int i = 0; i < n; i++) {
                if (!opened[i]) {
                    opened[i] = true;
                    recursive(i, masterKeyCount, openRoomCount + 1, !changed, rooms);
                    opened[i] = false;
                }
            }
        }else{
            for(int i = 0; i < n; i++){
                if(!opened[i]){
                    opened[i] = true;
                    recursive(rooms[i]-1, masterKeyCount+1, openRoomCount+1, changed, rooms);
                    opened[i] = false;
                }
            }
        }
    }
    public static int solution(int [] rooms){
        answer = Integer.MAX_VALUE;
        n = rooms.length;
        opened = new boolean[n];
        for(int i = 0; i < n; i++){
            opened[i] = true;
            recursive(rooms[i]-1,1,1,false, rooms);
            opened[i] =  false;
        }
        return answer;
    }
    public static void main(String[] args){
        int [] rooms = new int [] {3,1,2,4};
        System.out.println(solution(rooms));
    }
}
