package OpenSurvey;

import java.util.*;

public class Pro3 {
    public static long find2(long start, int target){
        ArrayList<Long> al = new ArrayList<Long>();
        al.add(Long.valueOf(0));
        int idx = 1, startIdx = 1;
        while(startIdx <= target){
            al.add((long)(Math.pow(3, idx)));
            int len = (int)(Math.pow(2, idx));
            int end = startIdx + len > target? target : startIdx+len;
            for(int i = startIdx+1; i < end; i++){
                al.add(al.get(startIdx)+al.get(i-startIdx));
                if(i > target){
                    break;
                }
            }
            idx += 1;
            startIdx = (int)(Math.pow(2, idx)) - 1;
        }
        return start + al.get(target);
    }
    public static long find(long start, int target){
        ArrayList<Long> al = new ArrayList<Long>();
        int [] dp = new int[target+1];
        Map<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
        String dd = " NOW" ;
        int idx = 0;
        while(al.size() <= target){
            int n = al.size();
            long now = (long)Math.pow(3, idx);
            al.add(now);
            for(int i = 0; i < n; i++){
                al.add(now+al.get(i));
                if(al.size() == target){
                    break;
                }
            }
            idx += 1;
        }
        return start + al.get(target-1);
    }
    public static long solution(long n){
        long idx = 0;
        while(idx < n){
            if(Math.pow(3, idx) > n){
                break;
            }else{
                idx ++;
            }
        }
        long startI = (long)Math.pow(2, idx) - 1;
        long startV = (long)Math.pow(3, idx);
        int target = (int)(n - startI);
        long result = find2(startV, target);
        return result;
    }
    public static void main(String[] args){
        long n = (long)(Math.pow(10,10))-1;
        System.out.println(solution(n));
    }
}
