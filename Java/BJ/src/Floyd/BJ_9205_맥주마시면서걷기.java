package Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_9205_맥주마시면서걷기 {
    static ArrayList<Pair> spots;
    static int [][] dist;
    static class Pair{
        int x, y;

        Pair(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String [] inputs;
        while(T -- > 0){
            int N = Integer.parseInt(br.readLine());
            spots = new ArrayList<>();
            dist = new int [N+2][N+2];
            for(int i = 0 ; i < N+2; i++){
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            for(int i = 0; i < N+2; i++){
                inputs = br.readLine().split(" ");
                int x = Integer.parseInt(inputs[0]);
                int y = Integer.parseInt(inputs[1]);
                spots.add(new Pair(x, y));
            }
            for(int i = 0 ; i < N+2; i++){
                for(int j = 0 ; j < N+2; j++){
                    if(i == j){
                        continue;
                    }
                    Pair now = spots.get(i);
                    Pair next = spots.get(j);
                    int dis = Math.abs(now.x - next.x) + Math.abs(now.y - next.y);
                    if(dis <= 1000){
                        dist[i][j] = 1;
                    }
                }
            }
            
            for(int x = 0; x < N+2; x++){   //중간
                for(int y = 0; y < N+2; y++){   //시작
                    for(int z = 0; z < N+2; z++){   //끝
                        if(dist[y][x] != Integer.MAX_VALUE && dist[x][z] != Integer.MAX_VALUE) {
                            if (dist[y][z] > dist[y][x] + dist[x][z]) {
                                dist[y][z] = dist[y][x] + dist[x][z];
                            }
                        }
                    }
                }
            }
            if(0 < dist[0][N+1] && dist[0][N+1] < Integer.MAX_VALUE){
                sb.append("happy");
            }else{
                sb.append("sad");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
