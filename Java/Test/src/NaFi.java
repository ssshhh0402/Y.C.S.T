public class NaFi {
    public static int [] solution(int n, int jump){
        int [] answer = new int[2];
        int [][] base = new int[n][n];
        int [] dx = new int[]{0,1,0,-1};
        int [] dy = new int [] {1,0,-1,0};
        boolean[][] visited = new boolean[n][n];
        int target = 2;
        int x = 0, y = 0;
        int a = 0, b = 0;
        int idx = 0;
        int count = 0;
        base[x][y] = 1;
        visited[0][0] = true;
        while(target != n*n){
            x = a + dx[idx];
            y = b + dy[idx];
            if(x >= 0 && x < n && y >= 0 && y < n){
                if(!visited[x][y]){
                    a = x;
                    b = y;
                    count += 1;
                    if(count == jump){
                        base[x][y] = target;
                        target += 1;
                        count = 0;
                    }
                }
            }else{
                idx += 1;
                if(idx == 4){
                    idx = 0;
                }
            }
        }
        return new int[]{a,b};
    }
    public static int [] solution2(int n, int jump){
        int [] answer = new int[2];
        boolean [] used = new boolean[n*n];
        int [] base = new int[n*n];
        int target = 1;
        for(int i = 0; i < n*n; i++){
            if(base[i] == 0){
                if(target == n*n){
                    answer[0] = i / n;
                    answer[1] = i % n;
                }
                int temps = i+jump;
                base[i] = target;
                target += 1;
                i = (i + jump) % (n*n);

            }
        }
        return answer;
    }
    public static void main(String[] args){
        int n = 5;
        int jump = 3;
//        int [] answers = solution(n, jump);
        int [] answers2 = solution2(n, jump);
        for(int answer : answers2){
            System.out.println(answer);
        }
    }
}
