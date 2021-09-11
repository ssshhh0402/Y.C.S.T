package KakaoLate;

public class Pro6 {
    public static int solution(int [][] board, int [][] skill){
        int n = board.length, m = board[0].length;
        int count = n * m;
        boolean [][] breaked = new boolean[n][m];
        for(int [] order : skill){
            int type = order[0], x1 = order[1],y1=order[2],x2 = order[3], y2= order[4],power = order[5];
            if(type == 1) {
                for (int x = x1; x < x2 + 1; x++) {
                    for (int y = y1; y < y2 + 1; y++) {
                        board[x][y] -= power;
                        if (board[x][y] <= 0 && !breaked[x][y]){
                            breaked[x][y] = true;
                            count -= 1;
                        }
                    }
                }
            }else{
                for(int x = x1; x < x2+1; x++){
                    for(int y = y1; y < y2+1; y++){
                        board[x][y] += power;
                        if(board[x][y] > 0 && breaked[x][y]){
                            breaked[x][y] = false;
                            count += 1;
                        }
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        int [][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int [][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        System.out.println(solution(board, skill));
}
}
