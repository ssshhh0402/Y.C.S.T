package LV3;

import java.util.*;

public class 카드뒤집기 {
    static class Position{
        int x, y, count;

        Position(int a, int b, int c){
            this.x = a;
            this.y = b;
            this.count = c;
        }
    }
    static int now_x, now_y;
    static ArrayList<String> temps;
    static Map<Integer, ArrayList<Position>> map;
    static boolean [] used;
    public static void permu(int now, int count, String route){
        if(now == count){
            temps.add(route);
            return;
        }
        for(int i = 1; i < count+1; i++){
            if(!used[i]){
                used[i] = true;
                permu(now+1, count,route+String.valueOf(i));
                used[i] = false;
            }
        }
    }
    public static int moving(String target){
        int t = Integer.parseInt(target);
        int one = getDistance(now_x, now_y, map.get(t).get(0)) + getDistance(map.get(t).get(0).x, map.get(t).get(0).y, map.get(t).get(1)) + 2;
        int two = getDistance(now_x, now_y, map.get(t).get(1)) + getDistance(map.get(t).get(1).x, map.get(t).get(1).y, map.get(t).get(0)) + 2;
        if(one > two){
            now_x = map.get(t).get(0).x;
            now_y = map.get(t).get(0).y;
            return one;
        }else{
            now_x = map.get(t).get(1).x;
            now_y = map.get(t).get(1).y;
            return two;
        }
    }
    public static int getDistance(int nowX, int nowY, Position target){
        Queue<Position> q = new LinkedList<Position>();
        int [] dx = new int [] {0,1,0,-1};
        int [] dy = new int [] {1,0,-1,0};
        boolean [][] visited = new boolean[4][4];
        visited[nowX][nowY] = true;
        q.add(new Position(nowX,nowY,0));
        int answer = 0;
        while(!q.isEmpty()){
            Position now = q.poll();
            if(now.x == target.x && now.y == target.y){
                answer = now.count;
                break;
            }
            for(int i = 0 ; i < 4; i++){
                int x = now.x+dx[i], y = now.y+dy[i];
                if(0 <= x && x < 4 && 0 <= y && y < 4){
                    if(!visited[x][y]){
                        visited[x][y] = true;
                        q.add(new Position(x,y,now.count+1));
                    }
                }
            }
            if(now.x != 3 && ! visited[3][now.y]){
                visited[3][now.y] = true;
                q.add(new Position(3, now.y, now.count+1));
            }
            if(now.x != 0 && !visited[0][now.y]){
                visited[0][now.y] = true;
                q.add(new Position(0,now.y, now.count+1));
            }
            if(now.y != 3 && !visited[now.x][3]){
                visited[now.x][3] = true;
                q.add(new Position(now.x, 3, now.count+1));
            }
            if(now.y != 0 && !visited[now.x][0]){
                visited[now.x][0] = true;
                q.add(new Position(now.x, 0, now.count+1));
            }
        }
        return answer;
    }
    public static int solution(int [][] board, int r, int c){
        int count = 0;
        int answer = Integer.MAX_VALUE;
        map = new LinkedHashMap<>();
        temps = new ArrayList<String>();
        now_x = r; now_y = c;
        for(int x = 0 ; x < 4; x++){
            for(int y = 0; y < 4; y++){
                if(board[x][y] != 0){
                    count += 1;
                    if(map.containsKey(board[x][y])){
                        ArrayList<Position> now = map.get(board[x][y]);
                        now.add(new Position(x,y,0));
                        map.replace(board[x][y], now);
                    }else{
                        ArrayList<Position> now = new ArrayList<Position>();
                        now.add(new Position(x,y,0));
                        map.put(board[x][y], now);
                    }
                }
            }
        }
        count /= 2;
        used = new boolean[count+1];
        for(int i = 1 ; i < count+1; i++){
            used[i] = true;
            permu(1,count,String.valueOf(i));
            used[i] = false;
        }
        for(String temp : temps){
            now_x = r;
            now_y = c;
            int result = 0;
            String [] toGo = temp.split("");
            for(String item : toGo){
                result += moving(item);
            }
            if(result < answer){
                answer = result;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        int r = 1;
        int c = 0;
        System.out.println(solution(board, r, c));
    }
}
