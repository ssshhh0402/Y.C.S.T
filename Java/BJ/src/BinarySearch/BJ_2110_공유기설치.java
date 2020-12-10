package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2110_공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int C = Integer.parseInt(inputs[1]);
        int[] base = new int[N];
        for (int i = 0; i < N; i++) {
            base[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(base);
        int left = 1;
        int right = base[N - 1] - base[0];
        int mid = 0;
        int answer = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            int remove = 1;
            int last = base[0];
            for (int i = 1; i < N; i++) {
                if (base[i] - last >= mid) {
                    remove += 1;
                    last = base[i];
                }
            }
            if (remove >= C) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
