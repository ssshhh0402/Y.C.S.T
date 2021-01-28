package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_14502_연구소 {
    static int [][] base;
    static ArrayList<Pair> az,aq;
    static int answer = 0;
    static int n,N,M;
    static boolean [] used;
    static String [] inputs;
    static int [] dx = {0,-1,0,1}, dy = {-1,0,1,0};
    static class Pair{
        int x, y;
        Pair(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    public static int dfs(){
        boolean[][] visited =new boolean[N][M];
        int count = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        q.addAll(aq);
        while(!q.isEmpty()){
            Pair now = q.poll();
            if(!visited[now.x][now.y]){
                count += 1;
                visited[now.x][now.y] = true;
            }else{
                continue;
            }
            for(int i = 0; i < 4; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if(0 <= x && x < N && 0 <= y && y < M){
                    if(!visited[x][y] && base[x][y] == 0) {
                        q.add(new Pair(x, y));
                    }
                }
            }
        }
        count = (az.size()+az.size()) - count - 3;
        return count;
    }
    public static void find(int count,int idx){
        if(count == 3){
            int now = dfs();
            answer = Math.max(answer, now);
            return;
        }
        for(int i = idx; i < n; i++){
            if(!used[i]){
                used[i] = true;
                base[az.get(i).x][az.get(i).y] = 1;
                find(count+1, i+1);
                used[i] = false;
                base[az.get(i).x][az.get(i).y] = 0;
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        base = new int[N][M];
        aq = new ArrayList<Pair>();
        az = new ArrayList<Pair>();
        for(int x = 0; x < N; x++){
            inputs = br.readLine().split(" ");
            for(int y = 0 ; y < M ; y++){
                base[x][y] = Integer.parseInt(inputs[y]);
                if(base[x][y] == 2){
                    aq.add(new Pair(x,y));
                }else if(base[x][y] == 0){
                    az.add(new Pair(x,y));
                }
            }
        }
        n = az.size();
        used = new boolean[n];
        find(0,0);
        System.out.println(answer);
    }
}
