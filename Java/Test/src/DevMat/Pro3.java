package DevMat;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Pro3 {
    static int [][] counts;
    static boolean [] visited;
    static ArrayList<Integer>[] map;
    static int N, K,  B;
    public static void recursive(int depth, int cost, ArrayList<Integer> routes){
        int before = routes.get(routes.size()-1);
        if(before == B){
            for(int i = 0; i < routes.size()-1; i++){
                int from = routes.get(i);
                int toGo = routes.get(i+1);
                counts[from][toGo] += 1;
                counts[toGo][from] +=1;
            }
            return;
        }
        if(cost == K){
            return;
        }
        for(int toGo : map[before]){
            if(!visited[toGo]){
                visited[toGo] = true;
                routes.add(toGo);
                recursive(depth+1, cost+1, routes);
                routes.remove(routes.size()-1);
                visited[toGo] = false;
            }
        }
    }
    public static int solution(int n, int [][] edges, int k, int a, int b){
        counts = new int [n][n];
        N = n;
        K = k;
        B = b;
        map = new ArrayList[n];
        for(int i = 0 ; i < n; i++) {
            map[i] = new ArrayList<Integer>();
        }
        visited = new boolean[n];
        for(int [] edge : edges){
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        visited[a] = true;
        al.add(a);
        recursive(1, 0, al);
        int answer = 0;
        for(int x = 0; x < n; x++){
            for(int y = 0 ; y < n; y++){
                if(x != y && counts[x][y] != 0){
                    answer += 1;
                }
            }
        }
        return answer / 2;
    }
    public static void main(String[] args){
        int n = 8;
        int [][] edges = new int [][] {{0,1},{1,2},{2,3},{4,0},{5,1},{6,1},{7,2},{7,3},{4,5},{5,6},{6,7}};
        int k = 4, a = 0, b = 3;
        System.out.println(solution(n,edges,k,a,b));
    }
}
