package LV3;

import java.util.*;

public class 리틀프렌즈사천성 {
    static int d;
    static ArrayList<String> routes;
    static boolean [][] removed;
    static boolean [] keyUsed;
    static Map<Character, ArrayList<int[]>> pairs;
    static Character [] keys;
    static int [] dx = new int[] {0,1,0,-1}, dy = new int [] {1,0,-1,0};
    public static class Spot{
        int x, y, dir;
        boolean flag;

        Spot(int a, int b, int c, boolean d){
            this.x = a;
            this.y = b;
            this.dir = c;
            this.flag = d;
        }
    }
    public static boolean isPossible(int [] spotOne, int [] spotTwo, String[] board){
        Queue<Spot> q = new LinkedList<Spot>();
        boolean flag = false;
        if(spotOne[0] == spotTwo[0] && spotOne[1] < spotTwo[1]){
            q.add(new Spot(spotOne[0], spotOne[1],0, false));
        }else if(spotOne[1] == spotTwo[1] && spotOne[0] < spotTwo[0]){
            q.add(new Spot(spotOne[0], spotOne[1], 1, false));
        }else if(spotOne[1] < spotTwo[1]){
            q.add(new Spot(spotOne[0], spotOne[1], 0, false));
            q.add(new Spot(spotOne[0], spotOne[1], 1, false));
        }else{
            q.add(new Spot(spotOne[0], spotOne[1], 0, false));
            q.add(new Spot(spotOne[0], spotOne[1], 3, false));
        }
        while(!q.isEmpty()){
            Spot now = q.poll();
            if(now.x == spotTwo[0] && now.y == spotTwo[1]){
                flag = true;
                break;
            }
            int x, y, nextDir;
            if(!now.flag){
                nextDir = now.dir + 1 > 3 ? 0 : now.dir+1;
                x = now.x+dx[nextDir]; y = now.y+dy[now.dir];
                if(0 <= x && x < board.length && 0 <= y && y < board[0].length()){
                    char target = board[x].charAt(y);
                    if(target == '.'){
                        q.add(new Spot(x, y, nextDir, !now.flag));
                    }else if(target != 'x' && removed[x][y]){
                        q.add(new Spot(x, y, now.dir, !now.flag));
                    }else if(target == board[spotOne[0]].charAt(spotOne[1])){
                        q.add(new Spot(x,y,now.dir, !now.flag));
                    }
                }
                nextDir = now.dir - 1 < 0 ? 3 : now.dir - 1;
                x = now.x+dx[nextDir]; y = now.y+dy[now.dir];
                if(0 <= x && x < board.length && 0 <= y && y < board[0].length()){
                    char target = board[x].charAt(y);
                    if(target == '.'){
                        q.add(new Spot(x, y, nextDir, !now.flag));
                    }else if(target != 'x' && removed[x][y]){
                        q.add(new Spot(x, y, now.dir, !now.flag));
                    }else if(target == board[spotOne[0]].charAt(spotOne[1])){
                        q.add(new Spot(x,y,now.dir, !now.flag));
                    }
                }
            }
            x = now.x+dx[now.dir]; y = now.y + dy[now.dir];
            if(0 <= x && x < board.length && 0 <= y && y < board[0].length()){
                char target = board[x].charAt(y);
                if(target == '.'){
                    q.add(new Spot(x, y, now.dir, now.flag));
                }else if(target != 'x' && removed[x][y]){
                    q.add(new Spot(x, y, now.dir, !now.flag));
                }else if(target == board[spotOne[0]].charAt(spotOne[1])){
                    q.add(new Spot(x,y,now.dir, !now.flag));
                }
            }
        }
        return flag;
    }
    public static void recursive(int depth, String route, String[] board){
        if(depth == d){
            routes.add(route);
            return;
        }
        for(int i = 0; i < d; i++){
            if(!keyUsed[i]){
                ArrayList<int[]> spots = pairs.get(keys[i]);
                if(isPossible(spots.get(0), spots.get(1), board)){
                    keyUsed[i] = true;
                    int [] spotOne = spots.get(0), spotTwo = spots.get(1);
                    removed[spotOne[0]][spotOne[1]] = true;
                    removed[spotTwo[0]][spotTwo[1]] = true;
                    recursive(depth+1, route+String.valueOf(board[spotOne[0]].charAt(spotOne[1])), board);
                    removed[spotOne[0]][spotOne[1]] = false;
                    removed[spotTwo[0]][spotTwo[1]] = false;
                    keyUsed[i] = false;
                }
            }
        }
    }
    public static String solution(int m, int n, String [] board){
        routes = new ArrayList<String>();
        removed = new boolean[n][m];
        pairs = new LinkedHashMap<Character, ArrayList<int[]>>();
        for(int x = 0; x < m; x++){
            for(int y = 0; y < n; y++){
                char now = board[x].charAt(y);
                if(now != '.' && now != '*'){
                    if(pairs.containsKey(now)){
                        ArrayList<int[]> al = pairs.get(now);
                        al.add(new int [] {x,y});
                        pairs.replace(now, al);
                    }else{
                        ArrayList<int[]> al = new ArrayList<int[]>();
                        al.add(new int[]{x,y});
                        pairs.put(now, al);
                    }

                }
            }
        }
        keys = pairs.keySet().toArray(new Character[pairs.size()]);
        d = keys.length;
        keyUsed=  new boolean[d];
        for(int i = 0; i < d; i++){
            if(!keyUsed[i]) {
                ArrayList<int[]> items = pairs.get(keys[i]);
                if (isPossible(items.get(0), items.get(1), board)){
                    int [] spotOne = items.get(0), spotTwo = items.get(1);
                    keyUsed[i] = true;
                    removed[spotOne[0]][spotOne[1]] = true;
                    removed[spotTwo[0]][spotTwo[1]] = true;
                    recursive(1, String.valueOf(keys[i]), board);
                    removed[spotOne[0]][spotOne[1]] = false;
                    removed[spotTwo[0]][spotTwo[1]] = false;
                    keyUsed[i] = false;
                }
            }
        }
        if(routes.isEmpty()){
            return "impossible";
        }else{
            Collections.sort(routes);
            return routes.get(0);
        }
    }
    public static void main(String[] args){
        int m = 3;
        int n = 3;
        String [] board = new String [] {"DBA", "C*A", "CDB"};
        System.out.println(solution(m,n,board));
    }
}
