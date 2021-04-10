package Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_10974_모든수열 {
    static int N;
    static int [] base;
    static boolean [] used;
    static StringBuilder sb = new StringBuilder();
    public static void find(int count, ArrayList<Integer> routes){
        if(count == N){
            for(int route : routes){
                sb.append(route).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i < N+1; i++){
            if(!used[i]){
                routes.add(i);
                used[i] = true;
                find(count+1, routes);
                routes.remove(routes.size()-1);
                used[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        base = new int[N+1];
        used = new boolean[N+1];
        for(int i = 1; i < N+1; i++){
            base[i] = i;
        }
        ArrayList<Integer> temps = new ArrayList<Integer>();
        for(int i = 1; i < N+1; i++){
            temps.add(i);
            used[i] = true;
            find(1,temps);
            temps.remove(0);
            used[i] = false;
        }
        System.out.print(sb.toString());
    }
}
