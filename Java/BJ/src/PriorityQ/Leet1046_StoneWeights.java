package PriorityQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet1046_StoneWeights {
    public static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int stone : stones){
            pq.add(stone);
        }
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            if(first != second){
                pq.add(first - second);
            }
        }
        if(pq.size() == 1){
            return pq.poll();
        }else{
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = inputs.length;
        int[] input = new int[N];
        for(int i = 0;i < N; i++){
            input[i] = Integer.parseInt(inputs[i]);
        }
        System.out.print(lastStoneWeight(input));
    }
}
