package Weekely;

public class TwelveWeek {
    static int answer, n;
    static boolean [] visited;
    public static void find(int count, int now, int [][] dungeons){
        answer = Math.max(count, answer);
        for(int i = 0; i < n; i++){
            if(!visited[i] && dungeons[i][0] <= now && now - dungeons[i][1] >= 0){
                visited[i] = true;
                find(count+1, now - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
    public static int solution(int k, int [][] dungeons){
        answer = 0;
        n = dungeons.length;
        visited = new boolean[n];
        find(0,k,dungeons);
        return answer;
    }
    public static void main(String[] args){
        int k = 80;
        int [][] dungeons = new int [][] {{80,20},{50,40},{30,10}};
        System.out.println(solution(k,dungeons));
    }
}
