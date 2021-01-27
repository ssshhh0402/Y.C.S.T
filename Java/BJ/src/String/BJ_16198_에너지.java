package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16198_에너지 {
    static int answer = 0;
    static int N;
    static int [] base;
    static boolean [] used;
    public static int[] calc(int start){
        int now = 1;
        int left = -1;
        int right = -1;
        for(int i = start - 1; i >= 0; i--){
            if(!used[i]){
                left = i;
                break;
            }
        }
        for(int i = start+1; i < N; i++){
            if(!used[i]){
                right = i;
                break;
            }
        }
        return new int [] {left, right};
    }
    public static void find(int count){
        answer = Math.max(answer, count);
        for(int i = 1; i < N-1; i++){
            if(!used[i]) {
                int[] spots = calc(i);
                if (spots[0] != -1 && spots[1] != -1) {
                    used[i] = true;
                    find(count + (base[spots[0]] * base[spots[1]]));
                    used[i] = false;
                }
            }
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        base = new int[N];
        used = new boolean [N];
        String[] inputs = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        find(0);
        System.out.println(answer);

    }
}
