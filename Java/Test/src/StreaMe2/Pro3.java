package StreaMe2;

import java.util.*;

public class Pro3 {
    static int answer;
    public static void recursive(int depth, int [] A, int [] B, int [] C){
        if(depth == A.length){
            Set<Integer> set = new HashSet<Integer>();
            for(int c : C){
                set.add(c);
            }
            int n = set.size();
            for(int i = 1; i <= n+1; i++){
                if(!set.contains(i)){
                    answer = Math.min(answer, i);
                    break;
                }
            }

            return;
        }
        if(A[depth] == B[depth]){
            C[depth] = A[depth];
            recursive(depth+1, A, B, C);
            C[depth] = 0;
        }else{
            C[depth] = A[depth];
            recursive(depth+1, A, B, C);
            C[depth] = B[depth];
            recursive(depth+1, A, B,C);
            C[depth] = 0;
        }
    }
    public static int solution(int [] A, int [] B){
        answer = Integer.MAX_VALUE;
        int [] C = new int[A.length];
        recursive(0, A, B, C);
        return answer;
    }
    public static void main(String[] args){
        int [] A = new int [] {1,2,4,3};
        int [] B = new int [] {1,3,2,3};
        System.out.println(solution(A,B));  //answer = 2, C = {1,3,4,3}
        A = new int [] {1,2};
        B = new int [] {1,2};
        System.out.println(solution(A,B)); // answer = 3, C = {1,2};
        A = new int [] {3,2,1,6,5};
        B = new int [] {4,2,1,3,3};
        System.out.println(solution(A,B)); // answer = 3, C = {4,2,1,6,5};
    }
}
