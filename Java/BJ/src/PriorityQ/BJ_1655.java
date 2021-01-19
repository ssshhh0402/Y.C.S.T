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
        int temp = Integer.parseInt(br.readLine());
        ma.add(temp);
        System.out.println(temp);
        for(int idx = 2; idx < N+1; idx++){
            temp = Integer.parseInt(br.readLine());
            if(ma.size() == mi.size()){
                ma.add(temp);
            }else{
                mi.add(temp);
            }
            if(mi.peek() <= ma.peek()){
                int temps = ma.poll();
                ma.add(mi.poll());
                mi.add(temps);
            }
            System.out.println(ma.peek());
        }
    }
}
