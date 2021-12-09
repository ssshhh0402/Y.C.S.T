package Bagle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Pro3 {
    public static int solution(int [] mmr){
        int answer = 0;
        int n = mmr.length;
        int m = n/2;
        Arrays.sort(mmr);
        int A = 0,B=0, count = 0;
        for(int i = 0; i < m; i++){
            if(i == (m-1) && (count%2 == 0)){
                B += mmr[i];
                A += mmr[i+1];
                break;
            }
            if(count%2 == 0){
                A += mmr[i];
                A += mmr[n-i-1];
            }else{
                B += mmr[i];
                B += mmr[n-i-1];
            }
            count += 1;
        }
        return Math.abs(A-B);
    }
    public static void main(String[] args){
        int [] mmr = new int [] {33,56,93,31,18,10,41,93};
        System.out.println(solution(mmr)); // 5
        mmr = new int [] {5,56,30,49,38,63};
        System.out.println(solution(mmr)); // 7
        mmr  = new int [] {5,15};
        System.out.println(solution(mmr)); // 10
    }
}
