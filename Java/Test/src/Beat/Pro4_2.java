package Beat;

public class Pro4_2 {
    static int [][] base;
    static boolean[] used = new boolean[13];
    static int answer;

    public static void recursive(int count, int now, int min, String routes){                  //몇번 돌렸나, 몇개 돌렸나, 최소
        if(now == 12){
            answer = Math.min(answer, count);
            return;
        }
        boolean flag = false;
        int a = base[count][0], b = base[count][1];
        if(a == b){
            if(!used[a+b]){
                used[a+b] = true;
                recursive(count+1, now+1, Math.min(min, a+b+1), routes+",["+String.valueOf(a+b)+"]");
                used[a+b] = false;
            }else{
                recursive(count+1, now, min, routes);
            }
        }else {
            for (int i = min; i < a + b; i++) {
                if (!used[i] && !used[a + b - i] && i != (a + b - i)) {
                    used[i] = true;
                    used[a + b - i] = true;
                    flag = true;
                    recursive(count + 1, now + 2, Math.min(min, i + 1), routes + ",[" + String.valueOf(i) + "," + String.valueOf(a + b - i) + "]");
                    used[i] = false;
                    used[a + b - i] = false;
                }
            }
            if (!flag && !used[a + b]) {
                used[a + b] = true;
                recursive(count + 1, now + 1, Math.min(min, a + b + 1), routes + ",[" + String.valueOf(a + b) + "]");
                used[a + b] = false;
            }
        }

    }
    public static int solution(int [][] casted){
        base = casted;
        answer = Integer.MAX_VALUE;
        int a = casted[0][0], b = casted[0][1];
        used[a+b] = true;
        recursive(1, 1, 1, "["+String.valueOf(a+b)+"]");
        used[a+b] = false;
        for(int i = 1; i < 7; i++){
            if(a+b-i <= 0){
                break;
            }
            if(i != a+b-i){
                used[i] = true;
                used[a+b-i] = true;
                recursive(1, 2, Math.min(1,i+1), "["+String.valueOf(i)+","+String.valueOf(a+b-i)+"]");
                used[i]= false;
                used[a+b-i] = false;
            }
        }
        if(answer == Integer.MAX_VALUE){
            return 1;
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        int [][] casted = new int [][] {{1,1},{5,6},{5,1},{5,5},{4,1},{6,6},{5,6},{5,6},{6,5},{3,6},{3,4}};
        System.out.println(solution(casted));
    }
}
