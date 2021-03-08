package Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11403_경로찾기 {
    static int N;
    static int [][] base;
    static boolean [] visited;
    public static void find(int x){
        for(int y = 0; y < N; y++){
            if(base[x][y] == 1 && !visited[y]) {
                visited[y] = true;
                find(y);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs;
        N = Integer.parseInt(br.readLine());
        base = new int[N][N];
        StringBuilder sb = new StringBuilder();
        for(int x = 0; x < N; x++){
            inputs = br.readLine().split(" ");
            for(int y = 0; y < N; y++){
                base[x][y] = Integer.parseInt(inputs[y]);
            }
        }
        for(int x = 0; x < N; x++){
            visited = new boolean[N];
            find(x);
            for(boolean visit : visited){
                if(visit){
                    sb.append(1 + " ");
                }else{
                    sb.append(0 + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

