import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_2075 {
    public static int find(PriorityQueue<Integer>[] base, int N){
        int answer = 0;
        int key = 0;
        for(int i = 0; i < N; i++){
            if(i == 0){
                answer = base[i].peek();
            }else{
                if(answer < base[i].peek()){
                    answer = base[i].peek();
                    key = i;
                }
            }
        }
        return key;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer>[] base = new PriorityQueue[N];
        for(int idx= 0; idx < N; idx++){
            base[idx]= new PriorityQueue<Integer>(Comparator.reverseOrder());
        }
        for (int x = 0; x < N; x++){
            String[] items = br.readLine().split(" ");
            for(int y=0;y < N; y++){
                base[y].add(Integer.parseInt(items[y]));
            }
        }
        int idx = 1;
        while(idx != N){
            int target = find(base, N);
            base[target].poll();
            idx += 1;
        }
        int answer = find(base, N);
        System.out.println(base[answer].peek());
    }
}
