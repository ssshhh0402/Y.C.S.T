package Sk;

public class Pro4 {
    public static int solution(int n , int [][] edges) {
        boolean[][] base = new boolean[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int[] edge : edges) {
            base[edge[0]][edge[1]] = true;
            base[edge[1]][edge[1]] = true;
        }
//        for(int x = 1; x <= n; x++){
//            for(int y = 1; y <= n; y++){
//                for(int j = 1; j <= n; j++){
//                    if(base[x][y] && base[y][j] && base[j][x]){
//                        if()
//                    }
//                }
//            }
//        }
//
//
//    }
        return 1;
    }
    public static void main(String[] args){
        int N = 5;
        int [][] edges = new int [][] {{0,1},{0,2},{1,3},{1,4}};
        System.out.println(solution(N, edges));
    }
}
