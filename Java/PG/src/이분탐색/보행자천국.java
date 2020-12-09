package 이분탐색;

public class 보행자천국 {
    public static int solution(int m, int n, int[][] citymap){
        int answer = 0;
        int [][][] base = new int[m+1][n+1][2];         // [0]이 가로, [1] 이 세로
        base[1][1][0] = base[1][1][1] = 1;
        for(int x = 1; x < m+1; x++){
            for(int y = 1; y < n+1; y++){
                if(citymap[x-1][y-1] == 0){
                    base[x][y][0] = base[x-1][y][0] + base[x][y-1][1];
                    base[x][y][1] = base[x-1][y][0] + base[x][y-1][1];
                }else if(citymap[x-1][y-1] == 2){
                    base[x][y][0] = base[x-1][y][0];
                    base[x][y][1] = base[x][y-1][1];
                }
            }
        }
        return answer;

    }
    public static void main(String[] args){
        System.out.println(solution(3,3,new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
        System.out.println(solution(3,6,new int [][] {{0,2,0,0,0,2},{0,0,2,0,1,0},{1,0,0,2,2,0}}));
    }
}
