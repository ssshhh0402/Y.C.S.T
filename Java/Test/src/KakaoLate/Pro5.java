package KakaoLate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pro5 {
    static ArrayList<Integer>[] base;
    static boolean [] visited;
    static int answer;

    public static int solution(int[] info, int[][] edges){
        int n = info.length;
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> nq=  new LinkedList<Integer>();
        ArrayList<Integer>[] base = new ArrayList[n];
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int [] edge : edges){
            int from = edge[0], to = edge[1];
            base[from].add(to);
        }
        boolean [] visited = new boolean[n];
        int count_y = 1;
        int count_n = 0;
        q.add(0);
        while(true){
            int N = q.size();
            for(int i = 0 ; i < N; i++) {
                int now = q.poll();
                if(!visited[now]){
                    visited[now] = true;
                }
                if(info[now] == 1){
                    count_n += 1;
                }
                for (int toGo : base[now]) {
                    if (!visited[toGo]) {
                        if (info[toGo] == 0) {
                            q.add(toGo);
                        } else {
                            nq.add(toGo);
                        }
                    }
                }
            }
            if(!q.isEmpty()){
                count_y += q.size();
            }else {
                answer = Math.max(count_y, answer);
                if(count_y - (count_n + 1) == 0){
                    break;
                }else {
                    q.add(nq.poll());
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] info = new int [] {0,0,1,1,1,0,1,0,1,0,1,1};
        int [][] edges = new int [][] {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        System.out.println(solution(info, edges));
    }
}
