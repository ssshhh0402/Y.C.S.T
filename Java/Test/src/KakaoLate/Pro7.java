package KakaoLate;

public class Pro7 {
    static int [][] base;
    static boolean [][] visited;
    static int answer, n;
    static int [] dx = new int [] {0,1,0,-1};
    static int [] dy = new int [] {1,0,-1,0};
    public static void find(int count, int aX, int aY, int bX, int bY){
        boolean flag = false;
        for(int i = 0 ; i <4; i ++){
            for(int j = 0; j < 4; j++){
                int NaX = aX+dx[i],NaY = aY + dy[i], NbX = bX+dx[i], NbY = bY+dy[i];
                if(0 <= NaX && NaX < n && 0 <= NaY && NaY < n && 0 <= NbX && NbX < n && 0 <= NbY && NbY < n){
                    if(!visited[NaX][NaY] && !visited[NbX][NbY]){
                        flag = true;
                        visited[NaX][NaY] = true;
                        visited[NbX][NbY] = true;
                        find(count+1, NaX, NaY, NbX, NbY);
                        visited[NaX][NaY] = false;
                        visited[NbX][NbY] = false;
                    }
                }
            }
        }
        if(!flag){
            answer = Math.max(answer, count);
        }
    }
    public static int solution(int[][] board, int [] aloc, int [] bloc){
        base = board;
        n = base.length;
        answer = Integer.MIN_VALUE;
        visited = new boolean [n][n];
        find(0,aloc[0],aloc[1],bloc[0],bloc[1]);
        return answer;
    }
    public static void main(String[] args){
        int [][] board = new int [][] {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int [] aloc = new int [] {1,0};
        int [] bloc = new int [] {1,2};
        System.out.println(solution(board, aloc, bloc));
    }
}
