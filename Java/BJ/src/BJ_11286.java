import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> over = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> under = new PriorityQueue<>(Comparator.reverseOrder());
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            if(n != 0){
                if (n > 0){
                    over.add(n);
                }else{
                    under.add(n);
                }
            }else{
                if(over.isEmpty() && under.isEmpty()){
                    System.out.println(0);
                }else if(over.isEmpty()){
                    System.out.println(under.poll());

                }else if(under.isEmpty()){
                    System.out.println(over.poll());
                }else{
                    int o = over.peek();
                    int u = under.peek();
                    if(Math.abs(o) == Math.abs(u)){
                        System.out.println(u);
                        under.poll();
                    }else if(Math.abs(o) < Math.abs(u)){
                        System.out.println(o);
                        over.poll();
                    }else{
                        System.out.println(u);
                        under.poll();
                    }
                }
            }
        }
    }
}
