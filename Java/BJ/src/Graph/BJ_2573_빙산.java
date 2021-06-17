package Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2573_빙산 {
    static int N, M;
    static int [][] base;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static class Item{
        int x, y;

        Item(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    public static void find(int a, int b, boolean [][] used){
        used[a][b] = true;
        int x,y;
        for(int i = 0 ; i < 4; i++){
            x = a +dx[i];
            y = b + dy[i];
            if(0 <= x && x < N && 0 <= y && y < M){
                if(base[x][y] != 0 && !used[x][y]){
                    find(x,y,used);
                }
            }
        }
    }


    public static int counting(){
        boolean [][] used = new boolean[N][M];
        int cnt = 0;
        for(int x = 0; x < N; x++){
            for(int y = 0 ; y < M; y++){
                if(base[x][y] != 0 && !used[x][y]){
                    find(x,y, used);
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
    public static void melt(){
        Queue<Item> q = new LinkedList<>();
        boolean[][] melted = new boolean[N][M];
        for(int x = 0 ; x < N; x++){
            for(int y = 0 ; y < M; y++){
                if(base[x][y] != 0){
                    melted[x][y] = true;
                    q.add(new Item(x,y));
                }
            }
        }
        while(!q.isEmpty()){
            Item now = q.poll();
            int count = 0;
            int x, y;
            for(int i = 0 ; i < 4; i++){
                x = now.x + dx[i];
                y = now.y + dy[i];
                if(0 <= x && x < N && 0 <= y && y < M){
                    if(base[x][y] == 0 && !melted[x][y]){
                        count += 1;
                    }
                }
            }
            if(base[now.x][now.y] - count < 0){
                base[now.x][now.y] = 0;
            }else{
                base[now.x][now.y] -= count;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        int answer = 0;
        base = new int[N][M];
        for(int x = 0; x < N; x++){
            inputs = br.readLine().split(" ");
            for(int y = 0; y < M; y++){
                base[x][y] = Integer.parseInt(inputs[y]);
            }
        }
        while(true){
            int count = counting();
            if(count >= 2){
                break;
            }else if(count == 0){
                answer = 0;
                break;
            }
            melt();
            answer += 1;
        }
        System.out.print(answer);
    }
}
