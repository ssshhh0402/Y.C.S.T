
public class 블록게임 {
    static int [][] base;
    static int n;
    public static int solution(int[][]  board){
        int answer = 0;
        base = board;
        n = board.length;
        for(int x = 0 ; x < n; x++){
            for(int y = 0; y < n; y++){
                if(board[x][y] != 0){
                    if(isOne(x,y)){
                        if(isPos(x+1,y+1, base[x][y]) && isPos(x+1,y+2,base[x][y])) {
                            delete(new int[] {x,x+1,x+1,x+1}, new int [] {y,y,y+1,y+2});
                            y = -1;
                            answer += 1;
                        }
                    }else if(isTwo(x,y)){
                        if(isPos(x+2,y-1,base[x][y])) {
                            delete(new int[] {x,x+1,x+2,x+2}, new int [] {y,y,y,y-1});
                            y = -1;
                            answer += 1;
                        }
                    }else if(isThree(x,y)){
                        if(isPos(x+2,y+1,base[x][y])) {
                            delete(new int [] {x,x+1,x+2,x+2}, new int [] {y,y,y,y+1});
                            x = 0;
                            y = -1;
                            answer += 1;
                        }
                    }else if(isFour(x,y)){
                        if(isPos(x+1,y-1,base[x][y]) && isPos(x+1,y-2,base[x][y])){
                            delete(new int [] {x,x+1,x+1,x+1}, new int [] {y,y,y-1,y-2});
                            x = 0;
                            y = -1;
                            answer += 1;
                        }
                    }else if(isFive(x,y)){
                        if(isPos(x+1,y-1,base[x][y]) && isPos(x+1,y+1,base[x][y])) {
                            delete(new int [] {x,x+1,x+1,x+1}, new int [] {y,y,y-1,y+1});
                            x = 0;
                            y = -1;
                            answer += 1;
                        }
                    }
                }
            }
        }
        return answer;
    }
    public static boolean isOne(int a, int b){
        if(a + 1 >= n || b + 2 >= n){
            return false;
        }
        int target = base[a][b];
        return base[a+1][b] == target && base[a+1][b+1] == target && base[a+1][b+2] == target;
    }
    public static boolean isTwo(int a, int b){
        if(a + 2 >= n || b-1 < 0){
            return false;
        }
        int target = base[a][b];
        return base[a+1][b] == target && base[a+2][b] == target && base[a+2][b-1] == target;
    }
    public static boolean isThree(int a, int b){
        if(a + 2 >= n || b + 1 >= n){
            return false;
        }
        int target = base[a][b];
        return base[a+1][b] == target && base[a+2][b] == target && base[a+2][b+1] == target;
    }
    public static boolean isFour(int a, int b){
        if(a + 1 >= n || b - 2 < 0){
            return false;
        }
        int target = base[a][b];
        return base[a+1][b] == target && base[a+1][b-1] == target && base[a+1][b-2] == target;
    }
    public static boolean isFive(int a, int b){
        if(a + 1 >= n || b - 1 < 0 || b + 1 >= n){
            return false;
        }
        int target = base[a][b];
        return base[a+1][b] == target && base[a+1][b-1] == target && base[a+1][b+1] == target;
    }
    public static boolean isPos(int a, int b, int target){
        for(int x = 0; x < a;  x++){
            if(base[x][b] != 0 && base[x][b] != target){
                return false;
            }
        }
        return true;
    }
    public static void delete(int [] xs, int [] ys){
        for(int i = 0 ; i < 4; i++){
            int x = xs[i], y = ys[i];
            base[x][y] = 0;
        }
    }


    public static void main(String [] args) {
        int [][] base = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}};
        System.out.println(solution(base));
    }
}

