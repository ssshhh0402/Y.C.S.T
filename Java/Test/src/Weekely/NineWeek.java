package Weekely;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NineWeek {
    static ArrayList<Integer>[] base;
    public static int find(int n, int x, int y){
        boolean [] visited = new boolean[n+1];
        ArrayList<Integer> al = new ArrayList<Integer>();
        Queue<Integer> q;
        for(int i = 1; i < n+1; i++){
            if(base[i].size() != 0 && !visited[i]){
                q = new LinkedList<Integer>();
                q.add(i);
                visited[i] = true;
                int count = 0;
                while(!q.isEmpty()){
                    int now = q.poll();
                    count += 1;
                    for(int toGo : base[now]){
                        if(!visited[toGo]){
                            if(!((now == x && toGo == y) || (now == y && toGo == x))){
                                visited[toGo] = true;
                                q.add(toGo);
                            }
                        }
                    }
                }
                al.add(count);
            }
        }
        if(al.size() == 2){
            return Math.abs(al.get(0) - al.get(1));
        }else{
            return -1;
        }
    }
    public static void init(int n, int [][] wires){
        base = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < wires.length; i++){
            int [] now = wires[i];
            base[now[0]].add(now[1]);
            base[now[1]].add(now[0]);
        }
    }
    public static int solution(int n, int [][] wires){
        init(n, wires);
        int answer = Integer.MAX_VALUE;
        for(int i = 0 ; i < wires.length; i++){
            int temps = find(n, wires[i][0],wires[i][1]);
            if(temps != -1){
                answer = Math.min(temps, answer);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int n = 9;
        int [][] wires = new int [][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(n, wires));
    }
}
