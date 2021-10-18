package Weekely;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElevenWeek {
    static int answer, targetX, targetY;
    static boolean [][] visited;
    static int [][] base;
    static boolean [] used;
    static int [] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    public static void find(int a, int b, int c){
        String target = "Hello";
        String [] targets = target.split("");

        if(a == targetX && b == targetY){
            answer = Math.min(c, answer);
            return;
        }
        for(int i = 0 ; i < 4; i++){
            int x = a + dx[i], y = b + dy[i];
            if(0 <= x && x < 51 && 0 <= y && y <51){
                if(!visited[x][y] && base[x][y] == -1){
                    visited[x][y] = true;
                    find(x,y,c+1);
                    visited[x][y] = false;
                }
            }
        }
    }
    public static int solution(int [][] rectangle, int characterX, int characterY, int itemX, int itemY){
        answer = Integer.MAX_VALUE;
        targetX = itemX;
        targetY = itemY; //이거 ArrayList로 해서 배열에다가 넣어보자
        visited = new boolean[51][51];
        base = new int[51][51];
        for(int i = 0 ; i < rectangle.length; i++){
            int [] now = rectangle[i];
            for(int x = now[0]; x <= now[2];x++){
                for(int y= now[1]; y <= now[3];y++){
                    if(x == now[0] || x == now[2] || y == now[1] || y == now[3]){
                        if(base[x][y] != 1){
                            base[x][y] = -1;
                        }
                    }else{
                        base[x][y] = 1;
                    }
                }
            }
        }
        find(characterX, characterY, 0);
        return answer;
    }
    public static void main(String[] args){
        int [][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        System.out.println(solution(rectangle, characterX, characterY,itemX, itemY));
    }
}
