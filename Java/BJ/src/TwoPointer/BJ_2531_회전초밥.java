package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class BJ_2531_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        Map<Integer, Integer> eated = new HashMap<Integer, Integer>();                           //먹은 초밥의 종류와 갯
        int N = Integer.parseInt(inputs[0]), d = Integer.parseInt(inputs[1]), k = Integer.parseInt(inputs[2]), c = Integer.parseInt(inputs[3]);
        int[] base = new int[N];
        eated.put(c, 1);
        for (int i = 0; i < N; i++) {
            base[i] = Integer.parseInt(br.readLine());
        }
        int s = 0, e = 0, answer = -1, count = 0;
        while (s <= e) {
            if (count < k) {
                int target = base[e];
                if (eated.containsKey(target)) {
                    eated.replace(target, eated.get(target) + 1);
                } else {
                    eated.put(target, 1);
                }
                e += 1;
                if (e == N) {
                    e = 0;
                }
                count += 1;
            }
            if( count == k){
                answer = Math.max(answer, eated.size());
                int s_i = base[s];
                int e_i = base[e];
                if(eated.containsKey(s_i)){
                    int s_temps = eated.get(s_i);
                    if(s_temps == 1){
                        eated.remove(s_i);
                    }else{
                        eated.replace(s_i, s_temps - 1);
                    }
                }
                if(eated.containsKey(e_i)){
                    int e_temps = eated.get(e_i);
                    eated.replace(e_i, e_temps + 1);
                }else{
                    eated.put(e_i, 1);
                }
                s += 1;
                e += 1;
                if(s == N){
                    s = 0;
                }
                if (e == N){
                    e = 0;
                }
            }
        }
        System.out.println(answer);
    }
}