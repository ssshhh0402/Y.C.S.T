package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1987_알파벳 {
    static int N, M;
    static Character[][] base;
    static boolean[][] visited;
    static String[] inputs;
    static boolean[] routes;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int answer = 0;
    public static void dfs(int a, int b, int count){
        answer = Math.max(count, answer);
        routes[base[a][b] - 'A'] = true;
        for(int i = 0; i < 4; i++){
            int x = a + dx[i];
            int y = b + dy[i];
            if(0 <= x && x < N && 0 <= y && y < M){
                if(!routes[base[x][y] - 'A']){
                    dfs(x,y,count+1);
                }
            }
        }
        routes[base[a][b] -'A'] = false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M =  Integer.parseInt(inputs[1]);
        base = new Character[N][M];
        routes = new boolean[26];
        for(int x = 0; x < N; x++){
            String input = br.readLine();
            for(int y = 0; y < M; y++){
                base[x][y] = input.charAt(y);
            }
        }
        dfs(0,0,1);
        System.out.println(answer);
    }
}
