package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_13460_구슬게임 {
    static class Pair{
        int x, y;

        Pair(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    static String [][] base;
    static int [] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    static int n,m;
    static int answer= Integer.MAX_VALUE;
    static Pair R, B;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        Queue<Pair> q = new LinkedList<Pair>();
        n = Integer.parseInt(inputs[0]); m = Integer.parseInt(inputs[1]);
        base = new String [n][m];
        for(int x = 0; x < n;x ++){
            inputs = br.readLine().split("");
            for(int y = 0 ; y < m; y++){
                base[x][y] = inputs[y];
                if(inputs[y].equals("R")){
                    R = new Pair(x,y);
                }else if(inputs[y].equals("B")){
                    B = new Pair(x,y);
                }
            }
        }
        q.add(R);
        q.add(B);
        while(!q.isEmpty()){
            Pair now_R = q.poll();
            Pair now_B = q.poll();
            for(int i = 0 ; i < 4; i++){
                Pair next_R = find(now_R, i);
                Pair next_B = find(now_B, i);
            }
        }
    }
}
