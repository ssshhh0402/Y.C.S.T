import java.util.LinkedList;
import java.util.Queue;

public class Review {
    public static int solution(int n, int [][] computers){
        int answer = 0;
        boolean [] used = new boolean[n];
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            if(!used[i]){
                answer += 1;
                q.add(i);
                while(!q.isEmpty()){
                    int x = q.poll();
                    for(int y = 0; y < n; y++){
                        if(computers[x][y] == 1 && !used[y]){
                            used[y] = true;
                            q.add(y);
                        }
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int n = 3;
        int [][] computers = new int [][] {{1,1,0}, {1,1,0},{0,0,1}};
        System.out.println(solution(n, computers));
        n = 3;
        computers = new int [][] {{1,1,0},{1,1,1},{0,1,1}};
        System.out.println(solution(n,computers));
    }
}
