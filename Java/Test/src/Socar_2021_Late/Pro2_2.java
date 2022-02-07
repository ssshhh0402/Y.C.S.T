package Socar_2021_Late;

import java.util.ArrayList;
import java.util.Arrays;

public class Pro2_2 {
    static ArrayList<int[]> al;
    static boolean [] used;
    static int n, answer;
    public static void init(int idx, int [] route, int [] numbers, int k){
        if(idx == n){
            al.add(Arrays.copyOf(route,n));
            return;
        }
        for(int i = 0; i < n; i++){
            if(!used[i] && Math.abs(route[idx-1] - numbers[i]) <= k){
                route[idx] = numbers[i];
                used[i] = true;
                init(idx+1, route, numbers, k);
                used[i] = false;
                route[idx] = 0;
            }
        }
    }
    public static int getCount(int [] route, int [] numbers){
        int count = 0;
        for(int i = 0 ; i < n; i++){
            if(route[i] != numbers[i]){
                for(int j = 0 ; j < n; j++){
                    if(route[i] == numbers[j]){
                        count += 1;
                        int temps = route[i];
                        route[i] = route[j];
                        route[j] = temps;
                    }
                }
            }
        }
        return count;
    }
    public static int solution(int [] numbers, int k){
        al = new ArrayList<int[]>();
        answer = Integer.MAX_VALUE;
        n = numbers.length;
        used = new boolean[n];

        int [] route = new int[n];
        for(int i = 0; i < n; i++){
            used[i] = true;
            route[0] = numbers[i];
            init(1, route, numbers, k);
            used[i] = false;
        }
        if(al.size() == 0){
            return -1;
        }else{
            for(int [] item : al){
                int counts = getCount(item, numbers);
                answer = Math.min(answer, counts);
            }
            return answer;
        }

    }
    public static void main(String [] args){
        int [] numbers = new int [] {10,40,30,20};
        int k = 20;
//        numbers = new int [] {3, 7, 2, 8, 6, 4, 5, 1};
//        k = 0;
//        numbers=  new int []{10,30,40,20};
//        k = 20;
        System.out.println(solution(numbers, k));
    }
}
