package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_5014_스타트링크 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<Integer>();
        String[] inputs = br.readLine().split(" ");
        int F = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);
        int G = Integer.parseInt(inputs[2]);
        int U = Integer.parseInt(inputs[3]);
        int D = Integer.parseInt(inputs[4]);
        long answer = Long.MAX_VALUE;
        q.add(S);

        int [] times = new int[F+1];
        times[S] = 1;
        while(!q.isEmpty()){
            Integer now = q.poll();
            if(now == G){
                answer = times[now]-1;
                break;
            }
            if(now + U <= F && times[now + U] == 0){
                q.add(now+U);
                times[now + U] = times[now]+1;
            }
            if(now - D > 0 && times[now - D] == 0){
                q.add(now - D);
                times[now - D] = times[now] + 1;
            }
        }
        if(answer == Long.MAX_VALUE){
            System.out.print("use the stairs");
        }else{
            System.out.print(answer);
        }
    }
}
