package KaKao_Intern;

import java.util.*;

public class Pro4 {
    static int [][] base;
    static class Pair{
        int end, weight;

        Pair(int a, int b){
            this.end = a;
            this.weight = b;
        }
    }
    public static void reverse(int target, int n){
        for(int i = 1; i < n+1; i++){
            if(base[target][i] != 0){                               // target이 바라보고 있는 애들 컷
                base[i][target] = base[target][i];
                base[target][i] = 0;
            }else if(base[i][target] != 0){                         //target을 바라보고있는 애들 컷
                base[target][i] = base[i][target];
                base[i][target] = 0;
            }
        }
    }

    public static int solution(int n, int start, int end, int [][] roads, int[] traps){
        int answer = Integer.MAX_VALUE;
        boolean [] map = new boolean[n+1];
        base= new int [n+1][n+1];
        int [] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair> pq = new LinkedList<Pair>();
        for(int trap : traps){
            map[trap] = true;
        }
        for(int [] road : roads){
            base[road[0]][road[1]] = road[2];
        }
        pq.add(new Pair(start,0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Pair now = pq.poll();
            if(now.end == end){
                answer = Math.min(now.weight, answer);
                continue;
            }
            if(now.weight > answer){
                break;
            }
            if(map[now.end]){
                reverse(now.end, n);
                dist[now.end] = Integer.MAX_VALUE;
            }
            for(int i = 1; i < n+1; i++){
                if(base[now.end][i] != 0){
                    if(dist[i] > now.weight + base[now.end][i]){
                        dist[i] = now.weight + base[now.end][i];
                        pq.add(new Pair(i, dist[i]));
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(3,1,3, new int [][] {{1, 2, 2}, {3, 2, 3}}, new int [] {2}));
        System.out.println(solution(4,1,4,new int [][] {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}}, new int [] {2,3}));
    }
}
