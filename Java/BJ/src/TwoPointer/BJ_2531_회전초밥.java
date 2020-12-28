package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class BJ_2531_회전초밥 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        Map<Integer,Integer> eated = new HashMap<Integer, Integer>();
        int N = Integer.parseInt(inputs[0]), d = Integer.parseInt(inputs[1]),k = Integer.parseInt(inputs[2]), c = Integer.parseInt(inputs[3]);
        int [] base = new int[N];
        eated.put(c, 1);
        for(int i = 0 ; i < N; i++){
            base[i] = Integer.parseInt(br.readLine());
        }
        int s = 0, e = 0, answer = -1, count=0;
        while(s <= e){
            if(count < k){
                if(eated.containsKey(base[e])){
                    eated.replace(base[e], eated.get(base[e])+1);
                }else{
                    eated.put(base[e], 1);
                }
                e += 1;
                count += 1;
            }else if(e == N){
                break;
            }else{
                int temps = eated.get(base[s]);
                if(temps == 1){
                    eated.remove(base[s]);
                }else{
                    eated.replace(base[s], temps - 1);
                }
                s += 1;
                count -= 1;
            }
            if(count == k){
                answer = Math.max(eated.size(), answer);
            }
        }
        System.out.println(answer);
    }
}

