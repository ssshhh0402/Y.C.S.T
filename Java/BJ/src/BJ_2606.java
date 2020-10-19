import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BJ_2606 {
    static int N,M;
    static int [][] base;
    static boolean [] used;
    static int answer = 0;
    public static void dfs(int x){
        used[x] = true;
        for (int i = 2; i < N+1; i++){
            if(base[x][i] == 1 && !used[i]){
                answer += 1;
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for (int idx = 0; idx< 2; idx++) {
                String options = br.readLine();
                StringTokenizer st = new StringTokenizer(options);
                if (idx == 0) {
                    N = Integer.parseInt(st.nextToken());
                }else{
                    M = Integer.parseInt(st.nextToken());
                }
            }
            used = new boolean[N+1];
            Arrays.fill(used, false);
            base = new int[N+1][N+1];
            for (int idx = 0; idx < M; idx++){
                String numbers = br.readLine();
                StringTokenizer st = new StringTokenizer(numbers);
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                base[start][end] = 1;
                base[end][start] = 1;
            }
            dfs(1);
            System.out.print(answer);
    }
}
