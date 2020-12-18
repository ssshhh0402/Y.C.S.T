import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
class L_Pair implements Comparable<L_Pair>{
    int end, weight;

    L_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
    public int compareTo(L_Pair l){
        return this.weight - l.weight;
    }
}
public class 가장먼노드 {

    public static int solution(int n, int [][] edge){
        ArrayList<L_Pair>[] base = new ArrayList[n+1];
        PriorityQueue<L_Pair> pq = new PriorityQueue<L_Pair>();
        int [] dist = new int[n+1];
        for(int i = 0 ; i < n+1; i++){
            base[i] = new ArrayList<L_Pair>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int [] item : edge){
            int start = item[0];
            int end = item[1];
            base[start].add(new L_Pair(end, 1));
            base[end].add(new L_Pair(start, 1));
        }
        dist[1] = 0;
        pq.add(new L_Pair(1, 0));
        while(!pq.isEmpty()){
            L_Pair now = pq.poll();
            for(L_Pair toGo : base[now.end]){
                int next = toGo.end;
                int weight = toGo.weight;
                if(dist[next] > dist[now.end] + weight){
                    dist[next] = dist[now.end] + weight;
                    pq.add(new L_Pair(next, dist[next]));
                }
            }
        }
        int count = 0;
        int answer = 0;
        for(int temps : dist){
            if(temps != Integer.MAX_VALUE){
                if(answer < temps){
                    answer = temps;
                    count = 1;
                }else if(answer == temps){
                    count += 1;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(solution(6, new int [][] {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}}));
    }
}
