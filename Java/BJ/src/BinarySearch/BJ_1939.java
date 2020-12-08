package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
class Pair{
    int weight;
    int end;

    Pair(int end, int weight){
        this.end= end;
        this.weight = weight;
    }
}
public class BJ_1939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        ArrayList<Pair>[] base = new ArrayList[N+1];
        int max_w = 0;
        for(int i = 0; i < N; i++){
            base[i] = new ArrayList<Pair>();
        }
        for(int i = 0; i < M; i++){
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);
            base[start].add(new Pair(end, weight));
            base[end].add(new Pair(start, weight));
            if(max_w < weight){
                max_w = weight;
            }
            
        }
    }
}
