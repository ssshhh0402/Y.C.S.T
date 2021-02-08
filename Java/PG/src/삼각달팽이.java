import java.util.LinkedList;
import java.util.Queue;

public class 삼각달팽이 {
    static int [][] base;
    static int [] dx = {1,0,-1};
    static int [] dy = {0,1,-1};
    static int N;
    static class Pair{
        int x, y, dir;

        Pair(int a, int b, int c){
            this.x = a;
            this.y = b;
            this.dir = c;
        }
    }
    public static Pair find(Pair a){
        int now_x = a.x;
        int now_y = a.y;
        int dir = a.dir;
        while(true){
            int x = now_x + dx[dir];
            int y = now_y + dy[dir];
            if(0 <= x && x < N && 0 <= y && y < base[x].length){
                if(base[x][y] == 0){
                    base[x][y] = base[now_x][now_y] + 1;
                    now_x = x;
                    now_y = y;
                }
                else{
                    break;
                }
            }else{
                break;
            }
        }
        if(dir == 2){
            return new Pair(now_x, now_y, 0);
        }else{
            return new Pair(now_x, now_y, dir+1);
        }
    }
    public static int [] solution(int n){
        int [] answer= {};
        base = new int[n][];
        N = n;
        Queue<Pair> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            base[i] = new int[i+1];
            count += (i+1);
        }
        answer = new int[count];
        base[0][0] = 1;
        q.offer(new Pair(0,0,0));
        while(true){
            Pair now = q.poll();
            Pair toGo = find(now);
            if(now.x == toGo.x && now.y == toGo.y){
                break;
            }else {
                q.offer(toGo);
            }
        }
        int i = 0;
        for(int x = 0; x < n; x++){
            for(int y = 0; y < base[x].length; y++){
                answer[i] = base[x][y];
                i += 1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] answers = solution(4);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
