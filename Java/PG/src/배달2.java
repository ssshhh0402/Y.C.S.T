import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class B_Pair implements Comparable<B_Pair>{
    int end, weight;
    B_Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
    @Override
    public int compareTo(B_Pair o){
        return this.weight - o.weight;
    }
}
public class 배달2 {
    public static int solution(int N, int[][] road, int K){
        int answer = 0;
        ArrayList<B_Pair>[] base = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++){
            base[i] = new ArrayList<B_Pair>();
        }
        for(int[] inputs : road){
            int start = inputs[0];
            int end = inputs[1];
            int weight = inputs[2];
            base[start].add(new B_Pair(end, weight));
            base[end].add(new B_Pair(start, weight));
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<B_Pair> pq = new PriorityQueue<B_Pair>();
        dist[1] = 0;
        pq.add(new B_Pair(1, 0));
        while(!pq.isEmpty()){
            B_Pair now = pq.poll();

            for(B_Pair toGo : base[now.end]){
                int next = toGo.end;
                int weight = toGo.weight;
                if(dist[next] > dist[now.end] + weight){
                    dist[next] = dist[now.end] + weight;
                    pq.add(new B_Pair(next, dist[now.end] + weight));
                }
            }
        }
        for(int i = 1; i < N+1; i++){
            if (dist[i] <= K){
                answer += 1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(5,new int [][] {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3));
        System.out.println(solution(6,new int [][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}},4));
    }
}
