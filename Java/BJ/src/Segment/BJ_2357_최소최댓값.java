package Segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2357_최소최댓값 {
    static int[] base;
    static int[] min_tree, max_tree;

    public static int min_init(int start, int end, int node) {
        if (start == end) {
            return min_tree[node] = base[start];
        }
        int mid = (start + end) / 2;
        return min_tree[node] = Math.min(min_init(start, mid, node * 2), min_init(mid + 1, end, node * 2 + 1));
    }

    public static int max_init(int start, int end, int node) {
        if (start == end) {
            return max_tree[node] = base[start];
        }
        int mid = (start + end) / 2;
        return max_tree[node] = Math.max(max_init(start, mid, node * 2), max_init(mid + 1, end, node * 2 + 1));
    }


    public static int find_min(int start, int end, int node, int left, int right) {
        if (end < left || right < start) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return min_tree[node];
        }
        int mid = (start + end) / 2;
        return Math.min(find_min(start, mid, node * 2, left, right), find_min(mid+1, end, node * 2 + 1, left, right));
    }

    public static int find_max(int start, int end, int node, int left, int right) {
        if (end < left || right < start) {
            return Integer.MIN_VALUE;
        }
        if (left <= start && end <= right) {
            return max_tree[node];
        }
        int mid = (start + end) / 2;
        return Math.max(find_max(start, mid, node * 2, left, right), find_max(mid+1, end, node * 2 + 1, left, right));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        base = new int[N + 1];
        min_tree = new int[N * 4];
        max_tree = new int[N * 4];
        for (int i = 1; i < N + 1; i++) {
            base[i] = Integer.parseInt(br.readLine());
        }
        min_init(1, N, 1);
        max_init(1, N, 1);
        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]);
            sb.append(find_min(1, N, 1, a, b)).append(" ").append(find_max(1, N, 1, a, b)).append("\n");

        }
        System.out.print(sb.toString());
    }
}
