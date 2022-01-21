package Ebay_2021_Late;

import java.util.ArrayList;
import java.util.Collections;

public class Pro2 {
    static int [] base;
    static ArrayList<String> al;
    static int n, m;
    public static boolean isPossible(int k){
        int zero_count = 0;
        int k_count = 0;
        for(int stone : base){
            if(stone == 0){
                zero_count += 1;
            }else if(stone == k){
                k_count += 1;
            }else{
                break;
            }
        }
        if(zero_count == n-1 && k_count == 1){
            return true;
        }else{
            return false;
        }
    }
    public static void recursive(String route, int k){
        if(isPossible(k)){
            int now = route.length();
            if(m > now){
                al = new ArrayList<String>();
                al.add(route);

            }else if(m == now){
                al.add(route);
            }
            return;
        }
        for(int i = 0; i < n; i++){
            base[i] += 1;
            int count = 0;
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                if(base[j] == 0){
                    for(int p = 0; p < j; p++){
                        if(i == p){
                            continue;
                        }
                        base[p] += 1;
                    }
                    break;
                }else{
                    base[j] -= 1;
                    count += 1;
                }
            }
            if(count == (n-1)){
                recursive(route + String.valueOf(i), k);
                for(int j = 0; j < n; j++){
                    if(i != j){
                        base[j] += 1;
                    }
                }
            }
            base[i] -= 1;
        }
    }
    public static String solution(int[] stones, int k){
        al = new ArrayList<String>();
        n = stones.length;
        m = Integer.MAX_VALUE;
        base = stones;
        for(int i = 0 ; i < n; i++){
            base[i] += 1;
            int count = 0;
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                if(stones[j] == 0){
                    for(int p = 0; p < j; p++){
                        base[j] += 1;
                    }
                    break;
                }else{
                    base[j] -= 1;
                    count += 1;
                }
            }
            if(count == (n-1)){
                recursive(String.valueOf(i), k);
                for(int j = 0; j < n; j++){
                    if(i != j){
                        base[j] += 1;
                    }
                }
            }
            base[i] -= 1;
        }
        Collections.sort(al);
        return al.get(al.size()-1);
    }
    public static void main(String[] args){
        int [] stones = new int []{1, 3, 2};
        int k = 3;
        System.out.println(solution(stones, k));
    }
}
