package LV3;

public class 경주로건설 {
    static int answer,n;
    static int [] dx = new int[]{0,0,1,-1}, dy = new int [] {1,-1,0,0}; //R,L,U,D
    static boolean [][] visited;
    public static String getDir(String now, int idx){
        if(now.equals("V")){
            if(idx < 2){
                return "H";
            }else{
                return "V";
            }
        }else{
            if(idx < 2){
                return "H";
            }else{
                return "V";
            }
        }
    }
    public static void find(int a, int b, String now, int money, int [][] board){
        if(a == n-1 && b == n-1){
            answer = Math.max(answer, money);
            return;
        }
        for(int i = 0 ; i < 4; i++){
            int x = a+dx[i], y = b+dy[i];
            if(0 <= x && x < n && 0 <= y && y < n){
                if(!visited[x][y] && board[x][y] == 0){
                    String result = getDir(now, i);
                    if(now.equals(result)) {
                        visited[x][y] = true;
                        find(x, y, result, money + 100, board);
                        visited[x][y] = false;
                    }else{
                        find(x,y,result, money + 600, board);
                    }
                }
            }
        }
    }
    public static int solution(int [][] board){
        answer = 0;
        n = board.length;
        visited = new boolean[n][n];
        visited[0][0] = true;
        find(0,0,"V",0, board);
        find(1,0,"H",0, board);
        return answer;
    }
    public static void main(String[] args){
        int [][] board = new int [][] {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(solution(board));
    }
}
