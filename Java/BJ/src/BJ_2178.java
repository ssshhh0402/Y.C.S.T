import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
public class BJ_2178 {
    static int N,M;
    static int base [][];
    static boolean used [][];
    static int answer = 0;
    public static void bfs(int x, int y) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 1});
        used[x][y] = true;
        while (!q.isEmpty()) {
            int now[] = q.poll();
            if (now[0] == (N - 1) && now[1] == (M - 1)) {
                if (now[2] > answer) {
                    answer = now[2];
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    int a = now[0] + dx[i];
                    int b = now[1] + dy[i];
                    if (a >= 0 && a < N && b >= 0 && b < M) {
                        if (base[a][b] == 1 && !used[a][b]) {
                            q.offer(new int[]{a, b,now[2]+1});
                            used[a][b] = true;
                            base[a][b] = base[now[0]][now[1]] + 1;
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String options = br.readLine();
        StringTokenizer st = new StringTokenizer(options, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        base = new int[N][M];
        used = new boolean[N][M];
        for(int x = 0; x < N; x++){
            String numbers = br.readLine();
            for(int y = 0; y < M; y++){
                base[x][y] = (numbers.charAt(y) - '0');
            }
        }
        for(int x= 0; x < N; x++){
            Arrays.fill(used[x], false);
        }
        bfs(0,0);
        System.out.print(answer);
    }
}
