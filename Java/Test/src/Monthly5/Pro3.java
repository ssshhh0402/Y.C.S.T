package Monthly5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pro3 {
    static ArrayList<Integer>[] base;
    static int [] toGo;

    public static long getSum(int start, int [] items){
        int count = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        while(!q.isEmpty()){
            int now = q.poll();
            count += items[now-1];
            for(int toGo : base[now]){
                q.add(toGo);
            }
        }
        return count;
    }
    public static void move(int start, int last, int [] items){
        while(true){
            if(start == 1){
                items[start] = last;
                break;
            }else{
                items[start] = items[toGo[start]];
                start = toGo[start];
            }
        }
    }

    public static long [] solution(int [] values, int [][] edges){
        int [][] queries = new int [][] {{1,-1},{2,-1},{3,-1},{4,-1},{5,-1},{4,1000},{1,-1},{2,-1},{3,-1},{4,-1},{5,-1},{2,1},{1,-1},{2,-1},{3,-1},{4,-1},{5,-1}};
        long [] answer = {};
        int n = values.length;
        ArrayList<Long> answers = new ArrayList<Long>();
        toGo = new int[n+1];
        base = new ArrayList[n+1];
//        items = new int[n+1];
//        for(int i = 0 ; i < n; i++){
//            items[i+1] = values[i];
//        }
        for(int i = 1; i < n+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int [] edge : edges){
            int root = edge[0], child = edge[1];
            toGo[child] = root;
            base[root].add(child);
        }
        for(int [] querie : queries){
            if(querie[1] == -1){
                answers.add(getSum(querie[0], values));
            }else{
                move(querie[0], querie[1], values);
            }
        }
        answer = new long[answers.size()];
        for(int i = 0;i  < answers.size(); i++){
            answer[i] = answers.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        long [] answers = solution(new int [] {1,10,100,1000,10000}, new int[][] {{1,2},{1,3},{2,4},{2,5}});
        for(long answer : answers){
            System.out.println(answer);
        }
    }
}
