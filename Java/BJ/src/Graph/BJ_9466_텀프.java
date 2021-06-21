package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9466_텀프 {
    static int count;
    static int [] base;
    static boolean [] visited, counted;
    public static void find(int now){
        if(visited[now]){
            return;
        }
        visited[now] = true;
        int toGo = base[now];
        if(!visited[toGo]){
            find(toGo);
        }else{
            if(!counted[toGo]){
                count += 1;
                while(toGo != now){
                    count += 1;
                    toGo = base[toGo];
                }
            }
        }
        counted[now] = true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N;
        String[] inputs;
        while(T -- > 0){
            count = 0;
            N = Integer.parseInt(br.readLine());
            base = new int[N+1];
            visited = new boolean[N+1];
            counted = new boolean[N+1];
            inputs = br.readLine().split(" ");
            for(int i = 1; i < N+1; i++){
                base[i] = Integer.parseInt(inputs[i-1]);
            }
            for(int i = 1; i < N+1; i++){
                find(i);
            }
            sb.append(N-count).append("\n");
        }
        System.out.print(sb.toString());
    }
}
