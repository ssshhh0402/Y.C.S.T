package Ebay_2021_Late;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pro1 {
    static int answer;
    public static int solution(String [][] schedule){
        answer = 0;
        int n = schedule.length;
        Map<String, ArrayList<Integer>>[] m = new LinkedHashMap[n];
        for(int i = 0; i < n; i++){
            m[i] = new LinkedHashMap<String, ArrayList<Integer>>();
        }
        boolean [] used = new boolean[n];
        for(int i = 0 ; i < n; i++){
            String [] classes = schedule[i];
            for(String cla : classes){
                String[] times = cla.split(" ");
                for(int j = 0; j < times.length; j+= 2){
                    String y = times[j];
                    String[] time = times[j+1].split(":");
                    int t = Integer.parseInt(String.join("", time));
                    if(m[i].containsKey(y)){
                        ArrayList<Integer> al = m[i].get(y);
                        al.add(t);
                        m[i].replace(y, al);
                    }else{
                        ArrayList<Integer> al = new ArrayList<Integer>();
                        al.add(t);
                        m[i].put(y, al);
                    }
                }
            }
        }

        return 1;
    }
    public static void main(String[] args){
        String [][] schedule = new String [][] {{"MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"}, {"TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"}, {"WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"}, {"TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"}, {"FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"}};
        System.out.println(solution(schedule));
    }
}
