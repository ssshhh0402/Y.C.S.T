package DisjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1717_집합의표현 {
    static int [] parents;
    public static int find(int target){
        if(parents[target] == target){
            return target;
        }else{
            return parents[target]= find(parents[target]);
        }
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parents[b] = a;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        parents = new int[N+1];
        for(int i =1; i < N+1; i++){
            parents[i] = i;
        }
        for(int i = 0; i < M; i++){
            inputs = br.readLine().split(" ");
            int one = Integer.parseInt(inputs[1]);
            int two = Integer.parseInt(inputs[2]);
            if(inputs[0].equals("0")){
                union(one, two);
            }else{
                one = find(one);
                two  = find(two);
                if(one == two){
                    sb.append("YES").append("\n");
                }else{
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}
