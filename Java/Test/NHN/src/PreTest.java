import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PreTest {
    public static void solution(int sizeOfMatrix, int[][] matrix){
        boolean [][] visited = new boolean [sizeOfMatrix][sizeOfMatrix];
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        ArrayList<Integer> counts = new ArrayList<Integer>();
        for(int x = 0; x < sizeOfMatrix; x++){
            for(int y=0; y < sizeOfMatrix; y++){
                if ((matrix[x][y] == 1) && (!visited[x][y])){
                    Queue<int[]> q = new LinkedList<int[]>();
                    q.offer(new int[]{x,y});
                    visited[x][y] = true;
                    int count = 1;
                    while(!q.isEmpty()){
                        int [] temps = q.poll();
                        for (int i = 0; i < 4; i++){
                            int a = temps[0] + dx[i];
                            int b = temps[1] + dy[i];
                            if (a >= 0 && a < sizeOfMatrix && b >= 0 && b < sizeOfMatrix){
                                if(matrix[a][b] == 1 && !visited[a][b]){
                                    count += 1;
                                    visited[a][b] = true;
                                    q.offer(new int[]{a,b});
                                }
                            }
                        }
                    }
                    if(count != 0) {
                        counts.add(count);
                    }
                }
            }
        }
        int n = counts.size();
        if (n == 0){
            System.out.println(0);
        }else{
            System.out.println(n);
            int [] answer = new int[n];
            for(int idx = 0; idx < n; idx++){
                answer[idx] = counts.get(idx);
            }
            Arrays.sort(answer);
            for(int item : answer){
                System.out.print(item + " ");
            }
            System.out.println("");
        }
    }
    public static void main(String [] args){
        solution(6,new int[][]{{0,1,1,0,0,0},{0,1,1,0,1,1},{0,0,0,0,1,1},{0,0,0,0,1,1},{1,1,0,0,1,0},{1,1,1,0,0,0}});
        solution(4, new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}});
    }
}
