package Segment;

import java.io.*;
public class BJ_1275_카페2_2 {
    private static class Segtree {
        int length_h;
        long[] arr;
        int pointer;

        Segtree(int N) { // The number of input data = N
            int length = 4;
            while (length < N) {
                length *= 2;
            }
            this.length_h = length;
            this.arr = new long[length * 2];
            this.pointer = length + 1;
        }

        void initial(int i) {
            arr[pointer++] = i;
        }

        void set() {
            for (int index = length_h - 1; index >= 1; index--) {
                arr[index] = arr[index * 2] + arr[index * 2 + 1];
            }
        }

        long find(int s, int e) {
            int index1 = length_h + s;
            int index2 = length_h + e;
            long sum = 0;
            while (index1 <= index2) {
                if ((index1 % 2) == 0) {
                    index1 /= 2;
                } else {
                    sum += arr[index1];
                    index1 = index1 / 2 + 1;
                }
                if ((index2 % 2) == 1) {
                    index2 /= 2;
                } else {
                    sum += arr[index2];
                    index2 = index2 / 2 - 1;
                }
            }
            return sum;
        }

        void replace(int i, int n) {
            int index = length_h + i;
            long diff = n - arr[index];
            while (index > 0) {
                arr[index] += diff;
                index /= 2;
            }
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
        Segtree segtree = new Segtree(N + 1);
        inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(inputs[i]);
            segtree.initial(now);
        }
        segtree.set();
        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]), y = Integer.parseInt(inputs[1]);
            int a = Integer.parseInt(inputs[2]), b = Integer.parseInt(inputs[3]);
            if (x > y) {
                sb.append(segtree.find(y,x));
            } else {
                sb.append(segtree.find(x, y));
            }
            sb.append("\n");
            segtree.replace(a, b);
        }
        System.out.print(sb.toString());
    }
}
