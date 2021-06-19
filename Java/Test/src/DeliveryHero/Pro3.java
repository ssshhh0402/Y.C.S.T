package DeliveryHero;

import java.io.IOException;

public class Pro3 {
    public static String solution(int U, int L, int [] C) {
        int N = C.length;
        int[][] base = new int[2][N];
        int[][] dp_row = new int[2][N];
        int[][] dp_col = new int[2][N];        //호율성을 따지는 걸로 보아 dp문제 인거같은데..
        //식이 생각안난다...
        for (int i = 0; i < N; i++) {
            if (C[i] == 2) {
                if (i == 0) {
                    dp_row[0][i] = 1;
                    dp_row[1][i] = 1;
                    dp_col[0][i] = 1;
                    dp_col[1][i] = 1;
                } else {
                    int min = Math.min(dp_row[0][i - 1], dp_row[1][i - 1]);
                    dp_row[0][i] = min;
                    dp_row[1][i] = min + 1;
                }
            }
        }
        return "IMPPOSIBLE";
    }
    public static void main(String[] args) throws IOException {
        System.out.println(solution(3, 2, new int [] {2, 1, 1, 0, 1}));
    }
}
