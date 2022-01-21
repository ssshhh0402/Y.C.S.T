package LineDH;

import java.util.Arrays;

public class Pro2_2 {
    static int m, answer;
    static boolean [] used;
    public static void recursive(int [] bankbook, int n, int count, int depth){
        boolean flag = false;
        for(int i = m-1; i >= 0; i--){
            if(!used[i]){
                used[i] = true;
                int counts = 1;
                int now = bankbook[i];
                for(int j = 0; j < i; j++){
                    if(!used[j]) {
                        if (now + bankbook[j] <= n) {
                            flag = true;
                            counts += 1;
                            now += bankbook[j];
                            used[j] = true;
                            recursive(bankbook, n, count + counts, depth + 1);
                            used[j] = false;
                        } else {
                            break;
                        }
                    }
                }
                used[i] = false;
            }
        }
        if(!flag){
            answer = Math.min(answer, m - count + depth);
        }
    }
    public static int solution(int n, int [] bankbook){
        Arrays.sort(bankbook);
        m = bankbook.length;
        answer = m;
        used= new boolean[m];
        for(int i = m-1; i >= 0; i--){
            int now = bankbook[i];
            used[i] = true;
            int count = 1;
            for(int j = 0; j < i; j++){
                if(now + bankbook[j] <= n){
                    count += 1;
                    now += bankbook[j];
                    used[j] = true;
                    recursive(bankbook, n, count,1);
                    used[j] = false;
                }else{
                    break;
                }
            }
            used[i] = false;
        }
        return answer;
    }
    public static void main(String [] args){
//        int n = 10;
//        int [] bankbook = new int [] {8,4,2,5,3,7};
//        System.out.println(solution(n,bankbook));
        int n = 10;
        int [] bankbook = new int [] {1,2,3,3,3,8};
        System.out.println(solution(n, bankbook));
    }
}
