import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BJ_2014 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int K = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int [] base = new int[K];
        String[] temps = br.readLine().split(" ");
        for(int idx = 0; idx < temps.length; idx++){
            int a= Integer.parseInt(temps[idx]);
            base[idx] = a;
            pq.offer(a);
        }
        while(pq.size() < N){
            for(int item : base){
                ArrayList<Integer> now = new ArrayList<Integer>();
                for(int item2 : pq){
                    int m_item = item * item2;
                    if (!pq.contains(m_item)){
                        now.add(m_item);
                    }
                }
                for(int item3: now){
                    pq.add(item3);
                }
            }
        }
        for(int idx = 0; )
        System.out.println("ForTesting");

    }

}
