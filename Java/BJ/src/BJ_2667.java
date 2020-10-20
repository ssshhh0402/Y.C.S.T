import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Arrays;

public class BJ_2667 {
    static int N;
    static int [][] base;
    static boolean [][] visited;
    static ArrayList<Integer> answer = new ArrayList<Integer>();
    public static int find(int x, int y){
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        int cnt = 1;
        q.offer(new int[] {x,y});
        while(!q.isEmpty()){
            int [] temps = q.poll();
            for(int i =0 ; i < 4; i++){
                int a = temps[0] + dx[i];
                int b = temps[1] + dy[i];
                if(a >= 0 && a < N && b >= 0 && b < N){
                    if (!visited[a][b] && base[a][b] == 1){
                        visited[a][b] = true;
                        q.offer(new int[]{a, b});
                        cnt += 1;
                    }
                }
            }
        }
        return cnt;
    }
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        base = new int[N][N];           // 단지 정보 저장할 배열
        visited = new boolean[N][N];    // 아파트 사용 했는지 안했는지 확인하기 위한 배
        for(int x= 0; x < N; x++){
            String numbers = br.readLine();
            for(int y = 0; y < N; y++){
               base[x][y] = numbers.charAt(y) - '0';
            }
            Arrays.fill(visited[x], false);
        }
        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                if (base[x][y] == 1 && !visited[x][y]){
                    int temps = find(x,y);
                    answer.add(temps);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int a = 0; a < answer.size(); a++){
            System.out.println(answer.get(a));
        }
    }
}
