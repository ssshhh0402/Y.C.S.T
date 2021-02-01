import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static int solution(int[][] maps){
        Queue<int[]> q = new LinkedList<int[]>();
        int n = maps.length;
        int m = maps[0].length;
        int [][] visited = new int [n][m];
        visited[0][0] = 1;
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        q.add(new int []{0,0});
        while(!q.isEmpty()){
            int [] now = q.poll();
            for(int i = 0 ; i < 4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(0 <= x  && x < n && 0 <= y && y < m){
                    if(maps[x][y] == 1 && visited[x][y] == 0){
                        visited[x][y] = visited[now[0]][now[1]] + 1;
                        q.add(new int [] {x,y});
                    }
                }
            }
        }
        if(visited[n-1][m-1] == 0){
            return -1;
        }else{
            return visited[n-1][m-1];
        }
    }
    public static void main(String[] args){
        System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,1,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }
}
