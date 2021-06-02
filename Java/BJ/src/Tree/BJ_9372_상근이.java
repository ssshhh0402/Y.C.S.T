package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_9372_상근이 {
    static class Pair{
        int now, count;

        Pair(int a, int b){
            this.now = a;
            this.count = b;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] base;
        String [] inputs;
        int N, M;
        while(T -- > 0){
            inputs = br.readLine().split(" ");
            int answer = 0;
            N = Integer.parseInt(inputs[0]); M = Integer.parseInt(inputs[1]);
            base = new ArrayList[N+1];
            for(int i = 1; i < N+1; i++){
                base[i] = new ArrayList<Integer>();
            }
            for(int i = 0; i < M; i++){
                inputs = br.readLine().split(" ");
                int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]);
                base[a].add(b); base[b].add(a);

            }
            sb.append(N-1).append("\n");
        }
        System.out.print(sb.toString());
    }
}
