package Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2268_수들의합 {
    static long [] base, tree;
    public static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = base[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }
    public static long Sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return Sum(start, mid, node * 2, left, right) + Sum(mid + 1, end, node * 2 + 1, left, right);
    }
    public static void Modify(int start, int end, int node, int idx, long dif) {
        if (idx < start || idx > end) {
            return;
        }
        tree[node] += dif;
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        Modify(start, mid, node * 2, idx, dif);
        Modify(mid + 1, end, node * 2 + 1, idx, dif);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        StringBuilder sb = new StringBuilder();
        base = new long[N+1];
        tree = new long [4 * N];

        init(1,N,1);
        for(int i = 0 ; i < M; i++){
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]), c = Integer.parseInt(inputs[2]);
            if(a == 0){
                if(b > c){
                    sb.append(Sum(1,N,1,c,b));
                }else{
                    sb.append(Sum(1,N,1,b,c));
                }
                sb.append("\n");
            }else if(a == 1){
                long diff = c - base[b];
                base[b] = c;
                Modify(1,N,1,b, diff);
            }
        }
        System.out.println(sb.toString());
    }
}
