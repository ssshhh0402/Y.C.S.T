package PriorityQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_1655 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        PriorityQueue<Integer> mi = new PriorityQueue<>();                // 큰거 => 작은거
        PriorityQueue<Integer> ma = new PriorityQueue<>(Comparator.reverseOrder()); // 작은거 => 큰거
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< N; i++){
            int now = Integer.parseInt(br.readLine());
            if(ma.size() == mi.size()){
                ma.add(now);
            }else{
                mi.add(now);
            }
            if(mi.size() == 0){
                sb.append(ma.peek() + "\n");
            }else{
                if(mi.peek() <= ma.peek()){
                    int temps = ma.poll();
                    ma.add(mi.poll());
                    mi.add(temps);
                }
                sb.append(ma.peek() + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
