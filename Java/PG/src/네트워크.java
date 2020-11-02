import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    public static int solution(int n, int[][] computers) {
        boolean[] used = new boolean[n];
        int answer = 0;
        for (int x = 0; x < n; x++) {
            if (!used[x]) {
                used[x] = true;
                answer += 1;
                Queue<Integer> q = new LinkedList<Integer>();
                q.offer(x);
                while(!q.isEmpty()){
                    int now = q.poll();
                    used[now] = true;
                    for(int toGo= 0; toGo < n; toGo++){
                        if(!used[toGo] && computers[now][toGo] == 1 && now != toGo){
                            q.offer(toGo);
                        }
                    }
                }
            }
        }
        return answer;
    }



    public static void main(String[] args){
        int answer;
        answer = solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}});
        System.out.println(answer);
        answer = solution(3, new int[][]{{1,1,0},{1,1,1},{0,1,1}});
        System.out.println(answer);
    }
}
