package Crema;

import java.util.ArrayList;
import java.util.List;

public class Pro5 {
    public static List<Long> solution(List<Long> a, List<Long>b){
//        List<Long> answer = new ArrayList<Long>();
//        for(int i = 0; i < a.size(); i++){
//            long lowest = Long.MAX_VALUE;
//            long A = a.get(i), B = b.get(i);
//            long left = 0, right = A, mid;
//            while(left <= right){
//                mid = (right+left) / 2;
//                long now = Math.abs(mid-(A-mid));
//                if(now == B){
//                    lowest = Math.min(2*mid + 3*(A-mid), lowest);
//                    left = mid+1;
//                }else if(now > B){
//                    left = mid+1;
//                }else{
//                    right = mid-1;
//                }
//            }
//            if(lowest == Long.MAX_VALUE){
//                answer.add(Long.valueOf(0));
//            }else{
//                answer.add(lowest);
//            }
//        }
//        return answer;
        List<Long> answer = new ArrayList<Long>();
        for(int i = 0; i < a.size(); i++){
            long lowest = Long.MAX_VALUE;
            long A = a.get(i), B = b.get(i);
            long left = 0, right = A, mid;
            while(left <= right){
                mid = (right+left) / 2;
                long now = (A-mid)^(mid);
                if(now >= B){
                    if(now == B){
                        lowest = Math.min(2*mid + 3*(A-mid), lowest);
                    }
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            if(lowest == Long.MAX_VALUE){
                answer.add(Long.valueOf(0));
            }else{
                answer.add(lowest);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        long [] A = new long [] {4,3,57};
        long [] B = new long [] {2,4,49};
//        A = new long [] {15,139};
//        B = new long [] {15, 75};
        List<Long> a = new ArrayList<Long>();
        List<Long> b = new ArrayList<Long>();
        for(long aa : A){
            a.add(aa);
        }
        for(long bb : B){
            b.add(bb);
        }
        List<Long>  answers = solution(a,b);
        for(long answer : answers){
            System.out.println(answer);
        }
    }
}
