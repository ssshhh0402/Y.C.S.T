package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_7795_먹을먹힐 {
    static String[] inputs;
    static int [] A, B;
    static int N,M;

    public static int find(int target){
        int count = 0;
        for(int i = 0; i < M; i++){
            if(B[i] < target){
                count += 1;
            }else{
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0){
            inputs = br.readLine().split(" ");
            int count = 0;
            N = Integer.parseInt(inputs[0]);
            M = Integer.parseInt(inputs[1]);
            A = new int [N];
            B = new int [M];
            inputs = br.readLine().split(" ");
            for(int i = 0 ; i < N; i++){
                A[i] = Integer.parseInt(inputs[i]);
            }
            inputs = br.readLine().split(" ");
            for(int i = 0 ; i < M; i++){
                B[i] = Integer.parseInt(inputs[i]);
            }
            Arrays.sort(B);
            for(int a : A){
                count += find(a);
            }
            sb.append(count + "\n");
        }
        System.out.print(sb.toString());
    }
}
