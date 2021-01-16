package Tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num2 {
    static ArrayList<Pair>[] base;
    static int friends_nodes;
    static int count= 0;
    static int answer= 0;
    static class Pair{
        int to, comp;

        Pair(int a, int b){
            this.to = a;
            this.comp = b;
        }
    }
    public static void find(Pair start){
        int target = start.comp;
        int temps = 1;
        boolean[] used = new boolean[friends_nodes+1];
        Queue<Pair> q = new LinkedList<Pair>();
        ArrayList<Integer> dist = new ArrayList<Integer>();
        q.add(start);
        dist.add(start.to);
        used[start.to] =true;
        while(true){
            Pair now = q.poll();
            for(Pair toGo : base[now.to]){
                if(toGo.comp == target&& !used[toGo.to]){
                    q.add(toGo);
                    dist.add(toGo.to);
                    used[toGo.to] = true;
                }
            }
            if(q.isEmpty()){
                break;
            }else{
                temps += 1;
            }
        }
        Collections.sort(dist);
        if(temps >=count){
            int now = dist.get(dist.size()-1) * dist.get(dist.size()-2);
            if(temps == count){
                answer = Math.max(now, answer);
            }else{
                count = temps;
                answer = now;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        friends_nodes = Integer.parseInt(br.readLine());
        String [] friends_from = br.readLine().split(" ");
        String [] friends_to = br.readLine().split(" ");
        String [] friends_weight = br.readLine().split(" ");
        base = new ArrayList[friends_nodes+1];
        int M = 0;
        for(int i = 0 ; i < friends_nodes+1; i++){
            base[i] = new ArrayList<Pair>();
        }
        for(int i = 0 ; i < friends_from.length; i++){
            int from = Integer.parseInt(friends_from[i]), to = Integer.parseInt(friends_to[i]), comp = Integer.parseInt(friends_weight[i]);
            M = Math.max(comp, M);
            base[from].add(new Pair(to, comp));
            base[to].add(new Pair(from, comp));
        }
        boolean[] comps = new boolean[M+1];
        for(int i = 0 ; i < base.length; i++){
            for(Pair item : base[i]){
                if(!comps[item.comp]) {
                    find(item);
                    comps[item.comp] = true;
                }
            }
        }
        System.out.println(answer);
    }
}
