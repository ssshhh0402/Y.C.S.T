package Sk;

public class Pro2 {
    static int [] dx, dy, endDx, endDy;
    static int [][] starts;
    static int endX, endY;
    public static void init(int n, boolean clockwise){
        if(clockwise){
            starts = new int [][] {{0,0}, {0,n-1}, {n-1,n-1}, {n-1,0}};
            dx = new int [] {0,1,0,-1};
            dy = new int [] {1,0,-1,0};
            endDx = new int [] {0,0,-1,-1};
            endDy = new int [] {0,-1,-1,0};
        }else{
            starts = new int [][] {{0,0}, {n-1,0}, {n-1,n-1}, {0,n-1}};
            dx = new int [] {1,0,-1,0};
            dy = new int [] {0,1,0,-1};
            endDx = new int [] {0,-1,-1,0};
            endDy = new int [] {0,0,-1,-1};
        }
    }
    public static int [][] printing(int a, int b, int dir, int n, int [][] answer){
        int count;
        int now = 1;
        int nowCount = 2;
        int value = 2;
        int len = n-2;
        answer[a][b] = 1;
        while (len > 0){
            int nextX = a+dx[dir], nextY = b+dy[dir];
            if(nextX == endX && nextY == endY){
                answer[nextX][nextY] = value;
                break;
            }
            count = len;
            for(int i = 0; i < count; i++){
                a += dx[dir];
                b += dy[dir];
                answer[a][b] = value;
                value += 1;
            }
            dir = (dir+1)% 4;
            if(now == nowCount){
                len -= 2;
                nowCount -=2;
                now = 0;
            }else{
                len -= 1;
                now += 1;
            }
        }
        if(answer[a+dx[dir]][b+dy[dir]] == 0){
            answer[a+dx[dir]][b+dy[dir]] = value;
        }
        return answer;
    }
    public static int [][] solution(int n, boolean clockwise){
        int [][] answer = new int[n][n];
        init(n, clockwise);
        for(int i = 0; i < 4; i++){
            endX = n/2; endY = n/2;
            if(n%2 == 0){
                endX += endDx[i];
                endY += endDy[i];
            }
            answer = printing(starts[i][0], starts[i][1], i, n, answer);
        }
        return answer;
    }
    public static void main(String[] args){
        int n = 5;
        boolean clockwise = true;
//        n = 6;
//        clockwise = false;
//        n = 9;
//        clockwise = false;
        int [][] answerss = solution(n, clockwise);
        for(int[] answers : answerss){
            for(int answer : answers){
                System.out.print(answer);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}
