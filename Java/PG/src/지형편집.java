public class 지형편집 {
    public static long calc(int target, int P, int Q, int[][] land){
        long answer = 0;
        for(int x = 0 ; x < land.length; x++){
            for(int y = 0 ; y < land[x].length; y++){
                if(land[x][y] < target){
                    answer += (P * (target - land[x][y]));
                }else if(land[x][y] > target){
                    answer += (Q * (land[x][y] - target));
                }
            }
        }
        return answer;
    }
    public static long solution(int[][] land, int P , int Q){
        long answer = -1;
        int n = land.length;
        int m = land[0].length;
        int s = Integer.MAX_VALUE, e = 0, mid=0;
        for(int x=0; x < n; x ++){
            for(int y = 0; y < m; y++){
                if(land[x][y] > e){
                    e = land[x][y];
                };
                if(land[x][y] < s){
                    s = land[x][y];
                };
            }
        }
        while(s <= e){
            if(s == e){
                break;
            }
            mid = (s + e) / 2;
            long comp = calc(mid, P, Q,land);
            long comp2 = calc(mid+1, P, Q, land);
            if(comp < comp2){
                e = mid-1;

            }else if(comp == comp2){
                answer = comp;
                break;
            }else{
                s = mid + 1;
            }
        }
        if(answer == -1){
            return calc(mid, P, Q, land);
        }else{
            return answer;
        }
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{1,2},{2,3}},3,2));
        System.out.println(solution(new int [][] {{4,4,3},{3,2,2},{2,1,0}},5,3));
    }
}
