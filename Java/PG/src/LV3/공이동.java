package LV3;

public class 공이동 {
    public static long solution(int n, int m, int x, int y, int [][] queries){
        long x_start = x, y_start = y, x_end = x, y_end = y;
        int [] dx = new int [] {0,0,1,-1}, dy = new int [] {1,-1,0,0};
        for(int i = queries.length-1; i >= 0; i--){
            int [] query = queries[i];
            if(query[0] == 0){
                if(y_start != 0){
                    y_start += dy[query[0]]*query[1];
                }
                y_end = Math.min(y_end+dy[query[0]]*query[1], m-1);
            }else if(query[0] == 1){
                y_start = Math.max(0, y_start+dy[query[0]]*query[1]);
                if(y_end != m-1){
                    y_end += dy[query[0]]*query[1];
                }
            }else if(query[0] == 2){
                if(x_start != 0){
                    x_start += dx[query[0]]*query[1];
                }
                x_end = Math.min(x_end+dx[query[0]]*query[1], n-1);
            }else{
                x_start = Math.max(0, x_start+dx[query[0]]*query[1]);
                if(x_end != n-1){
                    x_end += dx[query[0]]*query[1];
                }
            }
            if(x_start > n-1 || x_end < 0 || y_start > m-1 || y_end < 0){
                return 0;
            }
        }
        return (int)(x_end - x_start +1) * (int)(y_end - y_start +1);
    }
    public static void main(String[] args){
        int n = 2, m = 2,x=0,y=0;
        int [][] queries = {{2,1},{0,1},{1,1},{0,1},{2,1}};
//        n = 2; m = 3; x = 0; y = 1;
//        queries = new int [][] {{3,1},{2,2},{1,1},{2,3},{0,1},{2,1}};
        System.out.println(solution(n,m,x,y,queries));

    }
}
