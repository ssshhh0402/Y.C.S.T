package PriorityQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BJ_1766 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        LinkedList<Integer>[] list = new LinkedList [n+1];
        int [] link = new int[n+1];
        for(int i = 1; i < n+1; i++){
            list[i] = new LinkedList<>();
        }
        for(int idx = 0; idx < m; idx++){
            strings = br.readLine().split(" ");
            list[Integer.parseInt(strings[0])].add(Integer.parseInt(strings[1]));
            link[Integer.parseInt(strings[1])] += 1;
        }
        for(int idx = 1; idx < n+1; idx++){
            if(link[idx] == 0){
                pq.offer(idx);
            }
        }
        while(!pq.isEmpty()){
            int now = pq.poll();
            sb.append(String.valueOf(now) + " ");
            for (int toGo : list[now]){
                link[toGo] -= 1;
                if(link[toGo] == 0){
                    pq.offer(toGo);
                }
            }
        }
        System.out.println(sb.toString());
    }
}

