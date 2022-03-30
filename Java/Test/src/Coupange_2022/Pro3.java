package Coupange_2022;

import java.util.Arrays;

public class Pro3 {
    public static int [] getReverse(int [] arr){
        int n = arr.length;
        int [] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = arr[n-i-1];
        }
        return result;
    }
    public static int [] solution(int[] arr){
        int n = arr.length;
        if(n == 1){
            return arr;
        }
        int [] result;
        int [] answer = new int[n];
        arr = getReverse(arr);
        int range;
        if(n%2 == 0){
            range = n/2;
        }else{
            range = (n/2)+1;
        }
        result = solution(Arrays.copyOfRange(arr, 0, range));
        for(int i = 0; i < range; i++){
            answer[i] = result[i];
        }
        result = solution(Arrays.copyOfRange(arr, range, n));
        for(int i = range; i < n; i++){
            answer[i] = result[i-range];
        }
        return answer;
    }
    public static void main(String[] args){
        int [] arr = new int [] {1,2,3,4,5,6};
        int [] answers = solution(arr);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
