package Goorm.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pro2 {
    static Map<String, ArrayList<Pair>> base;
    static long answer = Long.MAX_VALUE;
    static class Pair{
        String end;
        int weight;

        Pair(String a, int b){
            this.end = a;
            this.weight = b;
        }
    }
    public static void find(String now, long cost, ArrayList<String> used){
        if(used.size() == base.keySet().size()){
            answer = Math.min(cost, answer);
            return;
        }else if (cost > answer){
            return;
        }
        if(base.containsKey(now)) {
            for (Pair toGo : base.get(now)) {
                if (!used.contains(toGo.end)) {
                    used.add(toGo.end);
                    find(toGo.end, cost + toGo.weight, used);
                    used.remove(used.size() - 1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] inputs;
        base = new LinkedHashMap<String, ArrayList<Pair>>();
        for(int i = 0 ; i < N; i++){
            inputs = br.readLine().split(" ");
            String start = inputs[0];
            String end = inputs[1];
            int weight = Integer.parseInt(inputs[2]);
            ArrayList<Pair> temps = new ArrayList<Pair>();
            if(base.containsKey(start)){
                temps = base.get(start);
                temps.add(new Pair(end ,weight));
                base.replace(start, temps);
            }else{
                temps.add(new Pair(end, weight));
                base.put(start, temps);
            }
            temps = new ArrayList<Pair>();
            if(base.containsKey(end)){
                temps = base.get(end);
                temps.add(new Pair(start, weight));
                base.replace(end, temps);
            }else{
                temps = new ArrayList<Pair>();
                temps.add(new Pair(start, weight));
                base.put(end, temps);
            }
        }
        for(String key : base.keySet()){
            ArrayList<String> used = new ArrayList<String>();
            used.add(key);
            find(key, 0, used);
            used.remove(used.size()-1);
        }
        System.out.println(answer);
    }
}
