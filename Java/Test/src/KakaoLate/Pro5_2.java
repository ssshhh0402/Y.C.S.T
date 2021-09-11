package KakaoLate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pro5_2 {
    static class Item{
        ArrayList<Integer> routes;
        int y_count, n_count;

        Item(ArrayList<Integer> a, int b, int c){
            this.routes = a;
            this.y_count = b;
            this.n_count = c;
        }
    }
    public static int solution(int [] info, int [][] edges){
        int n = info.length;
        Queue<Item> q = new LinkedList<Item>();
        ArrayList<Integer>[] base = new ArrayList[n];
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int [] edge : edges){
            int from = edge[0], to = edge[1];
            base[from].add(to);
        }
        ArrayList<Integer> temps = new ArrayList<Integer>();
        temps.add(0);
        q.add(new Item(temps, 1,0));
        while(!q.isEmpty()){
            Item now = q.poll();
            answer = Math.max(answer, now.y_count);
            for(int route : now.routes){
                for(int toGo : base[route]){
                    if(!now.routes.contains(toGo)){
                        ArrayList<Integer> newRoute = new ArrayList<Integer>();
                        newRoute.addAll(now.routes);
                        if(info[toGo] == 0){
                            newRoute.add(toGo);
                            q.add(new Item(newRoute, now.y_count+1, now.n_count));
                        }else{
                            if(now.n_count + 1 < now.y_count){
                                newRoute.add(toGo);
                                q.add(new Item(newRoute, now.y_count, now.n_count+1));
                            }
                        }
                    }
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
