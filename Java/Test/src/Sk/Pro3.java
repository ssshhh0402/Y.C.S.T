package Sk;

import java.util.Arrays;

public class Pro3 {
    static int answer;
    static int n,m;
    static boolean [][] used;
    public static void recursive(int x, int y, int [][] map){
        if(x == n && y == m){
            answer = (answer+1) % 10000019;

            return;
        }
        if(x + 1 <= n){
            used[x+1][y] = true;
            recursive(x+1, y, map);
            used[x+1][y] = false;
        }
        if( y + 1 <= m){
            used[x][y+1] = true;
            recursive(x, y+1, map);
            used[x][y+1] = false;
        }
        if(map[x][y] == 1){
            if(0 <= x-1 && x -1 <= n && 0 <= y-1 && y-1 <= m){
                if(map[x-1][y-1] == 1 && !used[x-1][y-1]){
                    used[x-1][y-1] = true;
                    recursive(x-1, y-1, map);
                    used[x-1][y-1] = true;
                }
            }
            if( x +1 <= n &&  y+1 <= m){
                if(map[x+1][y+1] == 1 && !used[x+1][y+1]){
                    used[x+1][y+1] = true;
                    recursive(x+1, y+1, map);
                    used[x+1][y+1] = false;
                }
            }
        }
    }
    public static int solution(int width, int height, int [][] diagonals){
        answer = 0;
        n = height;
        m = width;
        int [][][] dp = new int[height+1][width+1][2];
        used = new boolean[height+1][width+1];
        int [][] base = new int[height+1][width+1];
        for(int[] diagonal : diagonals){
            base[diagonal[0]-1][diagonal[1]] = 1;
            base[diagonal[0]][diagonal[1]-1] = 1;
        }
        for(int x = 0; x < height+1; x++){
            for(int y = 0; y < width+1; y++){
                Arrays.fill(dp[x][y], Integer.MAX_VALUE);

            }        }
        for(int x = 1; x < height+1; x++){
            dp[x][0][0] = 1;
        }
        for(int y = 0; y < width+1; y++){
            dp[0][y][0] = 1;
        }
        for(int x = 1 ;x < height+1; x++){
            for(int y=  1; y < width+1; y++){
                dp[x][y][0] = dp[x-1][y][0] + dp[x][y-1][0] + 1;
                if(base[x][y] == 1){
                    dp[x][y][1] = Math.min(dp[x-1][y][0], Math.min(dp[x][y-1][0], dp[x-1][y-1][0]))+1;
                }
            }
        }
        return Math.min(dp[width][height][0], dp[width][height][1]);
//        for(int i = 0; i < )
    }
    public static void main(String[] args){
        int width = 2;
        int height = 2;
        int [][] diagonals = new int [][] {{1,1},{2,2}};
        System.out.println(solution(width, height, diagonals));
    }
}
