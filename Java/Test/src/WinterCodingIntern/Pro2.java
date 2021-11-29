package WinterCodingIntern;

public class Pro2 {
    static int answer;
    static int[][] base;
    static int t, g;
    public static void find(int level, int now, int money){
        if(now == t){
            answer = Math.max(answer, money);
            return;
        }
        //  분기점 끝까지 갈것인가, 그 다음 곡괭이 까지 갈것인가?
        int stones = (t-now) / base[level][1];
        find(level, t, money+g*stones);
        if(level+1 < base.length){
            int target_gold = base[level+1][0];
            if(target_gold <= money){
                find(level+1, now, money - target_gold);
            }else {
                int count = target_gold / g;
                if (target_gold % g != 0) {
                    count += 1;
                }

                int target_time = count * base[level][1];
                int now_money = money + (g * count) - base[level + 1][0];
                find(level + 1, now + target_time, now_money);
            }
        }

    }
    public static int solution(int time, int gold, int[][] upgrade){
        answer = Integer.MIN_VALUE;
        t = time;
        g = gold;
        base = upgrade;
        find(0,0,0);
        return answer;
    }
    public static void main(String[] args){
        int time = 100;
        int gold = 200;
        int [][] upgrade = new int [][]{{0,5},{1500,3},{3000,1}};
       // System.out.println(solution(time,gold,upgrade));
        time = 11;
        gold = 1000;
        upgrade = new int [][] {{0, 5}, {100, 4}, {200, 3}};
        System.out.println(solution(time,gold,upgrade));
    }
}
