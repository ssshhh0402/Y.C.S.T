
public class 합승택시 {
    public static int solution(int n, int s, int a, int b, int[][] fares){
        int answer = Integer.MAX_VALUE;
        int [][] dist = new int[n+1][n+1];
        int IMF = 20000000;
        for(int[] fare : fares){
            int start = fare[0];
            int end = fare[1];
            int cost = fare[2];
            dist[start][end] = cost;
            dist[end][start]= cost;
        }
        for(int x = 1; x < n+1; x++){
            for(int y = 1; y < n+1; y++){
                if(x != y && dist[x][y] ==0){
                    dist[x][y] = IMF;
                }
            }
        }
        for(int x = 1; x < n+1; x++){               // 중간
            for(int y = 1; y < n+1; y++){           //시작
                for(int z = 1; z < n+1; z++){       //끝
                    int temps = Math.min(dist[y][x] + dist[x][z], dist[y][z]);
                    dist[y][z] = temps;
                    dist[z][y] = temps;
                }
            }
        }
        for(int i = 1; i < n+1; i++){
            answer = Math.min(dist[s][i] + dist[i][a] + dist[i][b], answer);
        }

        return answer;
    }
    public static void main(String[] args) {
        int [][] data = new int [][] {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(6,4,6,2,data));
    }
}
