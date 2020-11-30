import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            PriorityQueue<Integer> mi_p = new PriorityQueue<>();
            PriorityQueue<Integer> ma_p = new PriorityQueue<>(Comparator.reverseOrder());
            String answer = "";
            int N = Integer.parseInt(br.readLine());
            System.out.println((N+1) / 2);
            int count = 0;
            while(N > 0) {
                String[] base = br.readLine().split(" ");
                int n = base.length;
                for (int idx = 0; idx < n; idx++) {
                    if (ma_p.size() == mi_p.size()) {
                        ma_p.offer(Integer.parseInt(base[idx]));
                    } else {
                        mi_p.offer(Integer.parseInt(base[idx]));
                    }
                    if (!mi_p.isEmpty()) {
                        if (ma_p.peek() > mi_p.peek()) {
                            int a = ma_p.poll();
                            int b = mi_p.poll();
                            mi_p.offer(a);
                            ma_p.offer(b);
                        }
                    }
                    if(idx % 2 == 0){
                        if(count == 9){
                            answer += ma_p.peek() + "\n";
                            count = 1;
                        }else{
                            answer += ma_p.peek() + " " ;
                            count += 1;
                        }
                    }
                }
                N -= n;
            }
            System.out.println(answer);
        }
        }
    }

