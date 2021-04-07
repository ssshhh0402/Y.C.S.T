package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10610_30 {
    static String[] inputs;
    static long answer = -1;
    static boolean[] used;
    public static void find(String target){
        long now = Long.parseLong(target);
        if(now % 30 == 0){
            answer = Math.max(answer, now);
            return;
        }
        for(int a = 0; a < inputs.length; a++){
            if(!used[a]) {
                used[a]= true;
                find(target + inputs[a]);
                used[a] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split("");
        used = new boolean[inputs.length];
        for(int x = 0; x < inputs.length; x++){
            used[x]=true;
            find(inputs[x]);
            used[x]=false;
            }
        System.out.println(answer);
    }
}

