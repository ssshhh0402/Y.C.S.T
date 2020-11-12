import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for(int t = 0; t < n; t++){
            int m = Integer.parseInt(br.readLine());
            if(m != 0){
                q.add(m);
            }else{
                if(q.size() != 0){
                    System.out.println(q.peek());
                    q.poll();
                }
                else{
                    System.out.println(0);
                }
            }
        }
    }
}
