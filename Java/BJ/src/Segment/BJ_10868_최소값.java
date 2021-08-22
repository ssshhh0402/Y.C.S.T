package Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10868_최소값 {
    static int [] base, tree;

    public static int init(int start, int end, int node){
        if(start == end){
            return tree[node] = base[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(start, mid, node*2), init(mid+1, end, node*2+1));
    }

    public static int find(int start, int end, int node, int left, int right){
        if(end < left || right < start){
            return Integer.MAX_VALUE;
        }
        if(left <= start && end <= right){
            return tree[node];
        }
        int mid = (start + end) / 2;
        return Math.min(find(start,mid,node*2, left, right), find(mid+1, end, node*2+1, left, right));
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        base = new int [N+1];
        tree = new int [4 * N];
        for(int i = 1; i < N+1; i++){
            base[i] = Integer.parseInt(br.readLine());
        }
        init(1,N,1);
        for(int i = 0; i < M; i++){
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]);
            int answer = find(1,N,1,a,b);
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
}
