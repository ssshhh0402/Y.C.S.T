import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;
public class BJ_1260 {
    static int base[][];
    static boolean used[];
    static int n,m,v;
    public static void dfs(int i){
        used[i] = true;
        System.out.print(i + " ");
        for (int j = 0; j < n+1; j++){
            if(!used[j] && base[i][j] == 1){
               dfs(j);
            }
        }
    }
    public static void bfs(int i){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(i);
        used[i] = true;
        while (!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for(int k = 1; k <= n; k++){
                if(base[x][k] == 1 && used[k] == false){
                    q.offer(k);
                    used[k] = true;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        base = new int[n+1][n+1];
        used = new boolean[n+1];
        for (int idx = 0 ; idx < n+1; idx++){
            Arrays.fill(base[idx], 0);
        }
        Arrays.fill(used, false);
        for(int i = 0; i< m; i++){
            String numbers = br.readLine();
            StringTokenizer number = new StringTokenizer(numbers, " ");
            int a = Integer.parseInt(number.nextToken());
            int b = Integer.parseInt(number.nextToken());
            base[a][b] = 1;
            base[b][a] = 1;
        }
        dfs(v);
        Arrays.fill(used, false);
        System.out.println();
        bfs(v);
    }

}

