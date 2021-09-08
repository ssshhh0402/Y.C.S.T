package LV3;

import java.util.Arrays;
import java.util.Collections;

public class 숫자게임 {

    public static int solution(int [] A, int [] B){
        int answer = 0;
        int n = A.length;
        boolean [] used = new boolean[n];
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = 0;
        for(int i = 0 ; i < n; i++){
            for(int j = idx; j < n; j++){
                if(A[i] < B[j] && !used[j]){
                    used[j] = true;
                    answer += 1;
                    idx = j+1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int [] A = {5,1,3,7};
        int [] B = {2,2,6,8};
        System.out.println(solution(A,B));
        A = new int [] {2,2,2,2};
        B = new int [] {1,1,1,1};
        System.out.println(solution(A,B));
    }
}
