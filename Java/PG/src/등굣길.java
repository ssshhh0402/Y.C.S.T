public class 등굣길 {
    public static int solution(int m, int n, int [][] peddles){
        int answer = 0;
        int [][] base = new int[n+1][m+1];
        for(int[] peddle : peddles){
            int x = peddle[0];
            int y = peddle[1];
            base[x][y] = -1;
        }
        for(int i = 1; i < n+1; i++){
            if(base[i][1] == 0){
                base[i][1] = 1;
            }else if(base[i][1] < 0){
                break;
            }
        }
        for(int i = 1; i < m+1; i++){
            if(base[1][i] == 0){
                base[1][i] = 1;
            }else if(base[1][i] < 0){
                break;
            }
        }
        for(int a = 2; a < n+1; a++){
            for(int b = 2; b < m+1; b++){
                if (base[a][b] < 0){
                    continue;
                }
                if(base[a-1][b] >= 0 && base[a][b-1] >= 0){
                    base[a][b] = base[a-1][b] + base[a][b-1];
                }else if(base[a-1][b] >= 0 && base[a][b-1] < 0){
                    base[a][b] = base[a-1][b];
                }else if(base[a][b-1] >= 0 && base[a-1][b] < 0){
                    base[a][b] = base[a][b-1];
                }
            }
        }
        return base[n][m];
    }
    public static void main(String[] args){
        System.out.println(solution(4,3,new int[][]{{2,2}}));
    }
}
