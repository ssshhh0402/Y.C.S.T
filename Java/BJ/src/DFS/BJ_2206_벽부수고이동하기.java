package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2206_벽부수고이동하기 {
    static String [] inputs;
    static int [][] base;
    static boolean [][][] visited;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int answer = Integer.MAX_VALUE;
    static int N, M;
    public static void find(){
        Queue<int []> q = new LinkedList<int [] >();
        q.offer(new int[] {0,0,0,0});
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == N-1 && now[1] == M-1) {
                answer = Math.min(now[3], answer);
            }
            for(int i = 0 ; i < 4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(0 <= x && x < N && 0 <= y && y < M){
                    if(!visited[x][y][now[2]]){
                        if(base[x][y] == 1){
                            if(now[2] == 0){
                                visited[x][y][now[2]+1] = true;
                                q.offer(new int[] {x,y,now[2]+1,now[3] + 1});
                            }
                        }else{
                            visited[x][y][now[2]] = true;
                            q.offer(new int[]{x,y,now[2],now[3]+1});
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); M = Integer.parseInt(inputs[1]);
        base = new int[N][M];
        visited = new boolean[N][M][2];
        for(int x = 0; x < N; x ++){
            inputs = br.readLine().split("");
            for(int y = 0 ; y < M; y++){
                base[x][y] = Integer.parseInt(inputs[y]);
            }
        }
        find();
        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer+1);
        }
    }
}
