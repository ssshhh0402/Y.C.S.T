package Midas;

public class Pro1 {
    public static int [][] solution(int N, int [][] mine){
        int [] dx = new int[]{0,1,0,-1,-1,-1,1,1};
        int [] dy = new int [] {1,0,-1,0,-1,1,-1,1};
        int [][] answer = new int[N][N];
        for(int [] item : mine){
            int a = item[0]-1, b = item[1]-1;
            answer[a][b] = -1;
            for(int i = 0; i < 8; i++){
                int x = a+dx[i], y = b+dy[i];
                if(0 <= x && x < N && 0 <= y && y < N){
                    if(answer[x][y] != -1) {
                        answer[x][y] += 1;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [][] answers = solution(9, new int [][] {{1, 1}, {1, 7}, {2, 7}, {3, 6}, {4, 1}, {4, 4}, {4, 8}, {8, 4}, {8, 5}, {9, 6}});
        for(int x = 0 ; x < 9; x ++){
            for(int y = 0; y < 9; y++){
                System.out.print(answers[x][y] + " ");
            }
            System.out.println("");
        }
    }
}
