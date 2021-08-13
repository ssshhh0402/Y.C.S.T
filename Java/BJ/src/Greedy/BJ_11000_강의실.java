package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class BJ_11000_강의실 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] times = new int[N][2];
        String [] inputs;
        for(int i = 0 ; i < N; i++){
            inputs = br.readLine().split(" ");
            for(int y = 0; y < inputs.length; y++){
                times[i][y] = Integer.parseInt(inputs[y]);
            }
        }
        Arrays.sort(times, new Comparator<int[]>(){
            public int compare(int[] one, int[] two){
                if(one[0] == two[0]){
                    return one[1] - two[1];
                }else{
                    return one[0] - two[0];
                }
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int start = times[i][0];
            int end = times[i][1];
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.offer(end);
        }
        System.out.println(pq.size());

    }
}
