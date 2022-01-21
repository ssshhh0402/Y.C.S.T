package LineDH;

import java.util.ArrayList;
import java.util.Arrays;

public class Pro2 {
    static int answer, m;
    static boolean [] used;
    public static void recursive(ArrayList<Integer> al, int [] bankbook, int n, int count){
        boolean flag = false;
        for(int idx =0; idx < al.size(); idx++){
            int item = al.get(idx);
            for(int i = 0; i < m; i++){
                if(!used[i] && item+bankbook[i] <= n){
                    flag = true;
                    used[i] = true;
                    al.remove(idx);
                    al.add(item+bankbook[i]);
                    recursive(al, bankbook, n, count+1);
                    used[i] = false;
                    al.remove(al.size()-1);
                    al.add(item);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = i+1; j < m; j++){
                if(!used[i] && !used[j] && bankbook[i]+bankbook[j] <= n){
                    flag = true;
                    al.add(bankbook[i]+bankbook[j]);
                    used[i] = true;
                    used[j] = true;
                    recursive(al, bankbook, n, count+2);
                    used[i] = false;
                    used[j] = false;
                    al.remove(al.size()-1);
                }
            }
        }
        if(!flag){
            answer = Math.min(answer, m-count + al.size());
        }
    }
    public static int solution(int n, int [] bankbook){
        answer = Integer.MAX_VALUE;
        m = bankbook.length;
        ArrayList<Integer> al = new ArrayList<Integer>(); // 내가 여태까지 합친 금액들 넣어둔 애들
        used = new boolean[m];
        for(int i = 0; i < m; i++){
            for(int j = i+1; j < m; j++){
                if(bankbook[i]+bankbook[j] <= n){
                    used[i] = true;
                    used[j] = true;
                    al.add(bankbook[i]+bankbook[j]);
                    recursive(al, bankbook, n, 2); // 내가 여태까지 합친 금액들, bankbook, n, 내가 합친 계좌 계수
                    al.clear();
                    used[i] = false;
                    used[j] = false;
                }
            }
        }
        if(answer == Integer.MAX_VALUE){
            return m;
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        int n = 10;
        int [] bankbook = new int [] {8,4,2,5,3,7};
        System.out.println(solution(n,bankbook));
        n = 10;
        bankbook = new int [] {1,2,3,3,3,8};
        System.out.println(solution(n, bankbook));
    }
}
