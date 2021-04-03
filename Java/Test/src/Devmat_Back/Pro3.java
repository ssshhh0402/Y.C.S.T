package Devmat_Back;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pro3 {
    public static int find(String [] enroll, String target){
        for(int i = 0; i < enroll.length; i++){
            if(enroll[i].equals(target)){
                return i;
            }
        }
        return 0;
    }
    public static int [] solution(String [] enroll, String[] referral, String[] seller, int [] amount){
        int [] answer = {};
        int n = enroll.length;
        int m = seller.length;
        int [] count = new int[n];
        int [] money = new int[n];
        int [] refer = new int [n];


        for(int i = 0 ; i < n; i++){
            if(!referral[i].equals("-")){
                int idx = find(enroll, referral[i]);
                count[idx] += 1;
                refer[i] = idx;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] answers = solution(new String [] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},new String [] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, new String [] {"young", "john", "tod", "emily", "mary"},new int [] {12,4,2,5,10});
    }
}
