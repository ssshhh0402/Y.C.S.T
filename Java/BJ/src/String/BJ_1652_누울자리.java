package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1652_누울자리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs;
        String[][] base = new String[N][N];
        for(int x = 0; x < N; x++){
            inputs = br.readLine().split("");
            for(int y = 0 ; y < N; y++){
                base[x][y] = inputs[y];
            }
        }
        long height = 0;
        long width = 0;
        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                if(base[x][y].equals(".")){
                    if(x+1 < N && base[x+1][y].equals(".")){
                        if(x + 2 == N || base[x+2][y].equals("X")){
                            height += 1;
                        }
                    }
                    if(y+1 < N && base[x][y+1].equals(".")){
                        if(y + 2 == N || base[x][y+2].equals("X")){
                            width += 1;
                        }
                    }
                }
            }
        }
        System.out.println(String.valueOf(width) + " " + String.valueOf(height));
    }
}
