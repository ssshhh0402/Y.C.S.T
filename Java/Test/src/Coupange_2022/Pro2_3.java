package Coupange_2022;

import java.util.ArrayList;

public class Pro2_3 {
    //이거 트리써서 했어야 할 것 같다
    static int n, answer;
    static boolean [] opened;
    static ArrayList<Integer> notOpened;
    public static void recursive(int now, int masterKeyCount, int openRoomCount, int [] rooms){
        if(openRoomCount == n){
            answer = Math.min(answer, masterKeyCount);
            return;
        }
        if(!opened[rooms[now]-1]){
            opened[rooms[now]-1] = true;
            recursive(rooms[now]-1, masterKeyCount, openRoomCount+1, rooms);
            opened[rooms[now]-1] = false;
        }else{
            for(int item : notOpened){
                if(!opened[item]){
                    opened[item] = true;
                    recursive(rooms[item]-1, masterKeyCount+1, openRoomCount+1, rooms);
                    opened[item] = false;
                }
            }
        }
    }
    public static int solution(int [] rooms){
        n = rooms.length;
        answer = Integer.MAX_VALUE;

        int now, next, open;
        for(int i = 0; i < n; i++){
            opened = new boolean[n];
            notOpened = new ArrayList<Integer>();
            now = i;
            open = 1;
            opened[i] = true;
            while(true){
                next = rooms[now]-1;
                if(!opened[next]){
                    open += 1;
                    opened[next] = true;
                    now = next;
                }else{
                    break;
                }
            }
            if(open == n){
                answer = 1;
                break;
            }else{
                for(int j = 0; j < n; j++){
                    if(!opened[j]){
                        notOpened.add(j);
                    }
                }
                for(int item : notOpened){
                    opened[item] = true;
                    recursive(item, 1, open+1, rooms);
                    opened[item] = false;
                }
//                for(int j = 0; j < n; j++){
//                    if(!opened[j]){
//                        opened[j] = true;
//                        recursive(j, 1, open+1, rooms);
//                        opened[j] = false;
//                    }
//                }
            }
        }
        return answer;
    }
    public static void main(String[] args){

        int [] rooms = new int [] {3,1,2,4}; // 1 <= rooms.length <= 200000
        System.out.println(solution(rooms));
    }
}
