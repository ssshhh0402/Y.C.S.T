package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2468_안전구역 {
    static int [][] base;
    static boolean [][] visited;
    static int [] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    static class Pair{
        int x, y;

        Pair(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    public static void find(int a, int b, int n, int target){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(a,b));
        while(!q.isEmpty()){
            Pair now = q.poll();
            for(int i = 0 ; i < 4; i++){
                int x = now.x + dx[i], y = now.y + dy[i];
                if(0 <= x && x < n && 0 <= y && y < n){
                    if(!visited[x][y] && base[x][y] > target){
                        visited[x][y] = true;
                        q.add(new Pair(x, y));
                    }
                }
            }

        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.MIN_VALUE;
        base = new int[N][N];
        String[] inputs;
        int answer = 0;
        for(int x = 0; x < N; x++){
            inputs = br.readLine().split(" ");
            for(int y = 0; y < N; y++){
                base[x][y] = Integer.parseInt(inputs[y]);
                M = Math.max(M, base[x][y]);
            }
        }
        for(int i = M-1; i >= 0; i--) {
            visited = new boolean [N][N];
            int count = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!visited[x][y] && base[x][y] > i){
                        visited[x][y] = true;
                        find(x,y,N,i);
                        count += 1;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}
