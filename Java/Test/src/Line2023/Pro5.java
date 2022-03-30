package Line2023;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Pro5 {
    public static long solution(int [] abilities, int k){
        long answer = 0;
        int n = abilities.length;
        Arrays.sort(abilities);
        if(n % 2 != 0){
            k -= 1;
            answer += abilities[0];
            for(int i = n-1; i >= 1; i-= 2){
                int one = abilities[i], two = abilities[i-1];
                if(one == two){
                    answer += one;
                }else{
                    if(k > 0){
                        answer += one;
                        k -= 1;
                    }else{
                        answer += two;

                    }
                }
            }
        }else{
            for(int i = n-1; i >= 0; i-= 2){
                int one = abilities[i], two = abilities[i-1];
                if(one == two){
                    answer += one;
                }else{
                    if(k > 0){
                        answer += one;
                        k -= 1;
                    }else{
                        answer += two;
                    }
                }
            }
        }
        return answer;


    }
    public static void main(String[] args){
        int [] abilities = new int [] {2, 8, 3, 6, 1, 9, 1, 9};
        int k = 2;
        System.out.println(solution(abilities, k));
    }
}
