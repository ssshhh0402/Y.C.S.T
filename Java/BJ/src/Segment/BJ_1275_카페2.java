package Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1275_카페2 {
    static long [] base,tree;
    public static long init(int start, int end, int node){
        if(start == end){
            return tree[node] = base[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }
    public static long sum(int start, int end, int node, int left, int right){
        if(end < left || right < start){
            return 0;
        }
        if(left <= start && end <= right){
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }
    public static void update(int start, int end, int node, int idx, long dif){
        if(idx < start || idx > end){
            return;
        }
        tree[node] += dif;
        if(start == end){
            return;
        }
        int mid = (start+end) / 2;
        update(start, mid, node*2, idx, dif);
        update(mid+1, end, node*2+1, idx, dif);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        base = new long[N+1];
        tree = new long[4 * N];
        inputs = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            base[i+1] = Long.parseLong(inputs[i]);
        }
        init(1,N,1);
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);
            long d = Long.parseLong(inputs[3]);
            long result = 0;
            if(a > b){
                result = sum(1, N, 1, b, a);
            }else{
                result = sum(1, N, 1, a, b);
            }
            sb.append(result).append("\n");
            long dif = d - base[c];
            base[c] = d;
            update(1,N,1,c,dif);
        }
        System.out.println(sb.toString());
    }
}
