package Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2042_구간합 {
    static long [] base;
    static long [] tree;
    public static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = base[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
    public static void update(int start, int end, int node, int idx, long dif) {
        if (idx < start || idx > end) {
            return;
        }
        tree[node] += dif;
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, dif);
        update(mid + 1, end, node * 2 + 1, idx, dif);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]), K = Integer.parseInt(inputs[2]);
        base = new long [N+1];
        tree = new long [N*4];
        for(int i = 1 ; i < N+1; i++){
            base[i] = Long.parseLong(br.readLine());
        }
        init(1,N,1);
        for(int i = 0 ; i < M+K; i++){
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]);
            long c = Long.parseLong(inputs[2]);
            if(a == 1){
                long diff = c - base[b];
                base[b] = c;
                update(1,N,1,b, diff);
            }else if(a == 2){
                sb.append(sum(1,N,1,b,(int)c)).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
