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
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int [] base = new int[K];
        String[] temps = br.readLine().split(" ");
        for(int idx = 0; idx < temps.length; idx++){
            int a= Integer.parseInt(temps[idx]);
            base[idx] = a;
            pq.offer(a);
        }
        while(N-- > 0){
            answer = pq.poll();
            for(int item2 : base){
                int m_item = answer * item2;
                pq.offer(m_item);

            }
        }
        for(int i = 0; i < pq.size(); i++){
            System.out.println(pq.poll());
        }
        System.out.println(answer);

    }

}
