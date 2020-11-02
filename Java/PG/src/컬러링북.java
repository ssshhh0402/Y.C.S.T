import java.util.Deque;
import java.util.LinkedList;

public class 컬러링북 {
    public static int[] solution(int m, int n, int [][] picture){
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        boolean [][] used = new boolean[m][n];
        int[] answer = new int[2];
        int target;
        for(int x = 0; x < m; x++){
            for (int y=0; y < n; y++){
                if(!used[x][y] && picture[x][y] != 0){
                    target = picture[x][y];
                    numberOfArea += 1;
                    int count = 1;
                    Deque<int []> q = new LinkedList<int[]>();
                    used[x][y] = true;
                    q.offer(new int[]{x,y});
                    while(!q.isEmpty()){
                        int [] now = q.poll();
                        for (int i = 0; i < 4; i++){
                            int a = now[0] + dx[i];
                            int b = now[1] + dy[i];
                            if(0 <= a && a < m && 0 <= b && b < n){
                                if(!used[a][b] && picture[a][b] == target){
                                    count += 1;
                                    used[a][b] = true;
                                    q.offer(new int[]{a,b});
                                }
                            }
                        }
                    }
                    if (count > maxSizeOfOneArea){
                        maxSizeOfOneArea = count;
                    }
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static void main(String [] args){
        int [] answer = solution(6,4, new int [][] {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}});
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        answer = solution(6, 4, new int [][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}});
        System.out.println(answer[0]);
        System.out.println(answer[1]);

    }
}
