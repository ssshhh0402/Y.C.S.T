package Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1799_비숍 {
    static String[] inputs;
    static boolean [][] used;
    static int [][] base;
    static ArrayList<Pair> starts;
    static class Pair{
        int x, y;

        Pair(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        base = new int[N][N];
        starts = new ArrayList<Pair>();
        used = new boolean [N][N];
        for(int x = 0; x < N; x++){
            inputs = br.readLine().split(" ");
            for(int y = 0; y < N; y++){
                if(inputs[y].equals("1")){
                    count += 1;
                    starts.add(new Pair(x,y));
                }
                base[x][y] = Integer.parseInt(inputs[y]);
            }
        }

    }
}
