import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class BJ_1012 {
    static int T,M,N,K;
    static int[][] base;
    static boolean[][] used;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void find(int x, int y){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        used[x][y] = true;
        while(!q.isEmpty()){
            int [] temps = q.poll();
            for (int i = 0; i < 4; i++){
                int a = temps[0] + dx[i];
                int b = temps[1] + dy[i];
                if(a >= 0 && a < M && b >= 0 && b < N){
                    if(base[a][b] == 1 && !used[a][b]){
                        used[a][b] = true;
                        q.offer(new int[] {a, b});
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            String options = br.readLine();
            StringTokenizer st = new StringTokenizer(options, " ");
            int count = 0;
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            base = new int[M][N];
            used = new boolean[M][N];
            for(int x = 0; x < M; x++){
                Arrays.fill(base[x], 0);
                Arrays.fill(used[x], false);
            }
            for(int idx=0; idx< K; idx++){
                String items = br.readLine();
                StringTokenizer st2 = new StringTokenizer(items, " ");
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                base[x][y] = 1;
            }
            for(int x = 0; x < M; x++){
                for(int y = 0; y < N; y++){
                    if (base[x][y] == 1 && !used[x][y]){
                        count += 1;
                        find(x, y);
                    }
                }
            }
            System.out.println(count);
        }
    }
}
