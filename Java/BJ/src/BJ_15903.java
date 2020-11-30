import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_15903 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        String[] base = br.readLine().split(" ");
        for (String item : base){
            pq.add(Long.parseLong(item));
        }
        for(int i = 0; i < m; i++){
            Long one = pq.poll();
            Long two = pq.poll();
            pq.add(one+two);
            pq.add(one+two);
        }
        long answer = 0;
        for(Long ans : pq){
            answer += ans;
        }
        System.out.println(answer);

    }
}
