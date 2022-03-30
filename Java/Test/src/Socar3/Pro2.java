package Socar3;

import java.util.Arrays;

public class Pro2 {
    static int n;
    static boolean [] used;
    public static int getSwap(int [] changed, int [] numbers){
        int count = 0;
        for(int i = 0; i < n; i++){
            if(changed[i] != numbers[i]){
                count += 1;
                for(int j = i+1; j < n; j++){
                    if(changed[j] == numbers[i]){
                        int target = changed[i];
                        changed[i] = changed[j];
                        changed[j] = target;
                        break;
                    }
                }
            }
        }
        return count;
    }
    public static int recursive(int depth, int [] changed, int [] numbers, int k){
        if(depth == n){
            return getSwap(Arrays.copyOf(changed, n), Arrays.copyOf(numbers, n));
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(!used[i] && Math.abs(numbers[i] - changed[depth-1]) <= k){
                changed[depth] = numbers[i];
                used[i] = true;
                answer = Math.min(answer,recursive(depth+1, changed, numbers, k));
                used[i] = false;
                changed[depth] = 0;
            }
        }
        return answer;
    }
    public static int recursive2(int depth, int [] changed, int [] numbers, int count, int k){
        if(depth == n){
            return count-1;
        }
        int answer= Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(!used[i] && Math.abs(numbers[i] - changed[depth-1]) <= k){
                used[i] = true;
                changed[depth] = numbers[i];
                if(i == depth){
                    answer = Math.min(answer, recursive2(depth+1, changed, numbers, count, k));
                }else{
                    answer = Math.min(answer, recursive2(depth+1, changed, numbers, count+1, k));
                }
                changed[depth] = numbers[i];
                used[i] = false;
            }
        }
        return answer;
    }
    public static int solution(int [] numbers, int K){
        int answer = Integer.MAX_VALUE;
        n = numbers.length;
        used = new boolean[n];
        int [] changed = new int [n];
        for(int i = 0; i < n; i++){
            changed[0] = numbers[i];
            used[i] = true;
            answer = Math.min(answer, recursive(1, changed, numbers, K));
            used[i] = false;
            changed[0] = 0;
        }
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        return answer;
    }
    public static void main(String[] args){
        int [] numbers = new int [] {10, 40, 30, 20};
        int k = 20;
        System.out.println(solution(numbers, k));
        numbers = new int [] {3, 7, 2, 8, 6, 4, 5, 1};
        k = 3;
        System.out.println(solution(numbers, k));
    }
}
