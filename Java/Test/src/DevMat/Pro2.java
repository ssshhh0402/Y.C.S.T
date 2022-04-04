package DevMat;

import java.util.*;

public class Pro2 {
    static String [][] map;
    static int n,N, m, answer;
    static String [] temps = new String []{"a","b","c"};
    static ArrayList<int[]> inputs;
    public static boolean isPossible(String [][] map){
        int [] dx = new int[]{0,-1,0,1}, dy = new int [] {-1,0,1,0};
        boolean [][] visited = new boolean[n][N];
        ArrayList<String> visitCharacter = new ArrayList<String>();
        Queue<int[]> q;
        for(int x = 0; x < n; x++){
            for(int y = 0 ; y < N; y++){
                if(!visited[x][y]){
                    if(visitCharacter.contains(map[x][y])){
                        return false;
                    }
                    visitCharacter.add(map[x][y]);
                    visited[x][y] = true;
                    q = new LinkedList<int[]>();
                    q.add(new int [] {x,y});
                    while(!q.isEmpty()){
                        int [] now = q.poll();
                        for(int i = 0; i < 4; i++){
                            int a = now[0]+dx[i], b = now[1] + dy[i];
                            if(0 <= a && a < n && 0 <= b && b < N){
                                if(!visited[a][b] && map[a][b].equals(map[x][y])){
                                    visited[a][b] = true;
                                    q.add(new int [] {a,b});
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void recursive(int depth){
        if(depth == m){
            if(isPossible(map)){
                answer += 1;
            }
            return;
        }
        int [] spot = inputs.get(depth);
        for(int i = 0; i < 3; i++){
            map[spot[0]][spot[1]] = temps[i];
            recursive(depth + 1);
            map[spot[0]][spot[1]] = "";
        }
    }
    public static int solution(String [] grid){
        inputs = new ArrayList<int[]>();
        n = grid.length;
        N = grid[0].length();
        map = new String[n][N];
        answer = 0;
        for(int x = 0; x < n; x++){
            String [] now = grid[x].split("");
            for(int y = 0; y < N; y++){
                if(now[y].equals("?")){
                    inputs.add(new int [] {x,y});
                }else{
                    map[x][y] = now[y];
                }
            }
        }
        m = inputs.size();
        int [] first = inputs.get(0);
        for(int i = 0; i < 3; i++){
            map[first[0]][first[1]] = temps[i];
            recursive(1);

        }
        return answer;
    }
    public static void main(String[] args){
        String [] grid = {"??b", "abc", "cc?"};
        System.out.println(solution(grid));
        grid = new String [] {"abcabcab","????????"};
        System.out.println(solution(grid));
        grid = new String [] {"aa?"};
        System.out.println(solution(grid));
    }
}
