import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ_1021_회전하는큐 {
    static String[] inputs;
    static int answer = 0;
    static LinkedList<Integer> dq;
    public static void find(int target) {
        int half = 0;
        int t_idx = 0;
        if(dq.size() % 2 == 0){
            half = dq.size() / 2 - 1;
        }else{
            half = dq.size() / 2;
        }
        for(int i = 0 ; i < dq.size(); i++){
            if(dq.get(i) == target){
                t_idx = i;
                break;
            }
        }

        if(half- t_idx >= 0){
            left(t_idx);
            answer += t_idx;
        }else{
            right(dq.size() - t_idx);
            answer += dq.size() - t_idx;
        }
        dq.poll();

    }
    public static void right(int target){
        for(int i = 0 ; i < target; i++){
            dq.addFirst(dq.pollLast());
        }
    }
    public static void left(int target){
        for(int i = 0 ; i < target; i++){
            dq.addLast(dq.pollFirst());
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dq = new LinkedList<Integer>();
        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        for(int i = 1; i < N+1; i++){
            dq.add(i);
        }
        inputs = br.readLine().split(" ");
        for(int i = 0 ; i < M; i++){
            int target = Integer.parseInt(inputs[i]);
            find(target);
        }
        System.out.println(answer);
    }
}
