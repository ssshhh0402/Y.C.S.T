package TodayHoust;

public class Pro2 {
    public static long getRoom(int [] bed, int [] table){
        int one = (bed[0] + table[0]) * Math.max(bed[1], table[1]);
        int two = (bed[1] + table[1]) * Math.max(bed[0], table[0]);
        int three = (bed[0] + table[1]) * Math.max(bed[1], table[0]);
        int four = (bed[1] + table[0]) * Math.max(bed[0], table[1]);
        return Math.min(one, Math.min(two, Math.min(three, four)));
    }
    public static long solution(int [][] beds, int [][] tables ,int cost){
        long answer = Long.MAX_VALUE;
        int n = beds.length;
        int m = tables.length;
        for(int x = 0; x < n; x++){
            for(int y = 0 ; y < m; y++){
                long room = getRoom(beds[x], tables[y]);
                long now = beds[x][2] + tables[y][2] + room * cost;
                answer = Math.min(answer, beds[x][2]+tables[y][2] + room * cost);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [][] beds = new int [][] {{4, 1, 200000}};
        int [][] tables = new int [][] {{2, 3, 100000}};
        int cost = 10000;
        System.out.println(solution(beds, tables, cost));
    }
}
