package Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11505_구간곱 {
    static int flag = 1000000007;
    static long [] base,tree;
    public static long init(int start, int end, int node){
        if(start == end){
            return tree[node] = base[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, node*2) * init(mid+1, end, node*2+1)) % flag;
    }
    public static long multiple(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 1;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return (multiple(start, mid, node * 2, left, right) * multiple(mid + 1, end, node * 2 + 1, left, right)) % flag;
    }
    public static long update(int start, int end, int node, int idx, long val) {
        if (idx < start || idx > end) {
            return tree[node];
        }
        if (start == end) {
            return tree[node] = val;
        }
        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node*2, idx, val) * update(mid+1, end, node*2+1, idx, val)) % flag;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]), K = Integer.parseInt(inputs[2]);
        base = new long[N+1];
        tree = new long[4 * N];
        for(int i = 1; i < N+1; i++){
            base[i] = Long.parseLong(br.readLine());
        }
        init(1,N,1);
        for(int j = 0; j < M+K; j++){
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]);
            long c = Long.parseLong(inputs[2]);
            if(a == 1){
                base[b] = c;
                update(1,N,1,b,c);
            }else if(a == 2){
                sb.append(multiple(1,N,1,b,(int)c));
                if(j != (M+K-1)){
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}
