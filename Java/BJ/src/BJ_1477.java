import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int L = Integer.parseInt(inputs[2]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        String[] base = br.readLine().split(" ");
        ArrayList<Integer> use = new ArrayList<Integer>();
        for(String item : base){
            use.add(Integer.parseInt(item));
        }
        Collections.sort(use);
        for(int idx = 0; idx < use.size()-1; idx++){
            pq.offer(Math.abs(use.get(idx) - use.get(idx+1)));
        }
    }
}
