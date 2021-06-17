package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_10451_순열그래프 {
    static ArrayList<Integer>[] base;
    static boolean [] used;
    static int answer, n;
    public static void find(int x){
        for(int toGo : base[x]){
            if(!used[toGo]){
                used[toGo] = true;
                find(toGo);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String [] inputs;
        while(T -- > 0){
            n = Integer.parseInt(br.readLine());
            base = new ArrayList[n];
            used = new boolean[n];
            for(int i = 0 ; i < n; i++){
                base[i] = new ArrayList<Integer>();
            }
            inputs = br.readLine().split(" ");
            for(int i = 0; i < n; i++){
                answer = 0;
                base[i].add((Integer.parseInt(inputs[i]))-1);
            }
            for(int i = 0 ; i < n; i++){
                if(!used[i]){
                    used[i] = true;
                    answer += 1;
                    find(i);
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
}
