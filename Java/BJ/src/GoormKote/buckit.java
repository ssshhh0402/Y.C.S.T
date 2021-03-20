package GoormKote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class buckit {
    public static int calc(int t, int x, int y, int [][] base){
        int count = 0;
        for(int a = x; a < a+t; a++){
            for(int b = y; b < y+t; b++){
                if( 0 <= a && a < base.length && 0 <= b && b < base.length) {
                    if (base[a][b] == 1) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }
    public static int find(int [][] base, int target){
        int answer = 0;
        for(int x = 0; x < base.length; x++){
            for(int y = 0 ; y < base.length; y++){
                int count = calc(x,y,target, base);
                if(count == target * target){
                    answer += 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        Map<Integer, Integer> answers = new LinkedHashMap<Integer,Integer>();
        int N = Integer.parseInt(br.readLine());
        int [][] base = new int[N+3][N+3];
        String[] inputs;
        for(int x=  1 ; x < N+1; x++){
            inputs = br.readLine().split("");
            for (int y = 1 ; y < N+1; y++){
                base[x][y] = Integer.parseInt(inputs[y-1]);
            }
        }
        for(int t = 1; t < N+1; t++){
            int count = find(base, t);
            answer += count;
            answers.put(t, count);
        }
        sb.append(answer);
        for(Integer key : answers.keySet()){
            sb.append("size["+key + "]: " + answers.get(key));
        }
    }
}
