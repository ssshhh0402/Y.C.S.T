import java.io.*;
import java.util.*;
class Main {
    static int N, M, G,x;
    static ArrayList<Integer>[] in ,out;
    static int [][] base;
    public static class Point{
        int point, weight;


        Point(int a, int b){
            this.point = a;
            this.weight = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); M = Integer.parseInt(inputs[1]); G = Integer.parseInt(inputs[2]);
        base = new int[N+1][N+1];
//        in = new ArrayList[N+1];
//        out = new ArrayList[N+1];
//        for(int i = 0; i < N+1; i++){
//            in[i] = new ArrayList<Integer>();
//            out[i] = new ArrayList<Integer>();
//        }
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            base[start][end]= 1;
        }
        inputs = br.readLine().split(" ");
        x = Integer.parseInt(inputs[0]);
        int s = Integer.parseInt(inputs[1]);
        int y = Integer.parseInt(inputs[2]);
        init();
        Queue<Point> q = new LinkedList<Point>();
        boolean [] visited = new boolean[N+1];
        q.add(new Point(s,0));
        visited[s] = true;
        int answer = 0;
        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.point == y){
                answer = now.weight;
                break;
            }
            for(int i = 0; i < N+1; i++){
                if(base[now.point][i] != 0 && !visited[i]){
                    visited[i] = true;
                    q.add(new Point(i, now.weight + base[now.point][i]));
                }

            }
        }
        System.out.println(answer);
    }
    public static void init(){
        Queue<Integer> q = new LinkedList<Integer>();
        int start = x;
        int count = 1;
        boolean [][] visited = new boolean[N+1][N+1];
        q.add(start);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0 ; i < n; i++){
                int now = q.poll();
                for(int x = 0; x < N+1; x++){
                    if(base[now][x] != 0 && !visited[now][x]){
                        visited[now][x] = true;
                        base[now][x] = count;
                        q.add(x);
                    }
                    if(base[x][now] != 0 && !visited[x][now]){
                        visited[x][now] = true;
                        base[x][now] = G - count+1;
                        q.add(x);
                    }
                }
            }
            count+=1;
        }
    }
    public static void initCome(){
        Queue<Integer> q = new LinkedList<Integer>();
        int end = x;
        int count = 1;
        q.add(end);
        boolean [] visited = new boolean[N+1];
        visited[end] = true;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++) {
                int now = q.poll();
                for (int a = 0; a < N + 1; a++) {
                    if (base[a][now] != 0 && !visited[a]) {
                        base[a][now] = count;
                        visited[a] = true;
                        q.add(a);
                    }
                }
            }
            count += 1;
        }
    }
    public static void initOut(){
        Queue<Integer> q = new LinkedList<Integer>();
        int start = x;
        int count = G;
        q.add(start);
        boolean [] visited = new boolean[N+1];
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int a = 0; a < N+1; a++) {
                if (base[now][a] != 0 && !visited[a]) {
                    base[now][a] = count;
                    visited[a] = true;
                    q.add(a);
                }
            }
            count -= 1;
        }
    }
}