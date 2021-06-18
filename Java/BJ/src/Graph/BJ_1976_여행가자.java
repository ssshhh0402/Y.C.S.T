package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1976_여행가자 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "YES";
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int [] [] base = new int[N+1][N+1];

        String [] inputs;
        for(int x = 1; x < N+1; x++){
            inputs = br.readLine().split(" ");
            for(int y = 1 ; y < N+1; y++){
                base[x][y] = Integer.parseInt(inputs[y-1]);
                if(x == y){
                    base[x][y] = 1;
                }
            }
        }
        for(int z = 1; z < N+1; z++){
            for(int x = 1; x < N+1; x++){
                for(int y = 1; y < N+1; y++){
                    if(base[x][z] == 1 && base[z][y] == 1){
                        base[x][y] = 1;
                    }
                }
            }
        }
        inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        for(int i = 1; i < M; i++){
            int next = Integer.parseInt(inputs[i]);
            if(base[start][next] == 0){
                answer = "NO";
                break;
            }else{
                start = next;
            }
        }
        System.out.println(answer);
    }
}
