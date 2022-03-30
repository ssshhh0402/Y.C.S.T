package LV3;

import java.util.PriorityQueue;

public class 셔틀버스 {
    public static long StoL(String time){
        String [] times = time.split(":");
        return (Long.parseLong(times[0]) * 60) + Long.parseLong(times[1]);
    }
    public static String LtoS(long time){
        String hour = time / 60 < 10? "0"+String.valueOf(time / 60) : String.valueOf(time / 60);
        String minutes = time % 60 < 10? "0" + String.valueOf(time % 60) : String.valueOf(time % 60);
        return hour + ":" + minutes;
    }
    public static String solution(int n, int t, int m, String [] timetable){
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for(String time : timetable){
            pq.add(StoL(time));
        }
        long start = 9 * 60, end = 0, people = 0;
        for(int i = 0; i < n; i++){
            people = 0;
            while(!pq.isEmpty()){
                long now = pq.peek();
                if(now <= start && people < m){
                    pq.poll();
                    people += 1;
                }else{
                    break;
                }
                end = now-1;
            }
            start += t;
        }
        if(people < m){
            end = start - t;
        }
        return LtoS(end);
    }
    public static void main(String[] args){
        int n = 1;
        int t= 1;
        int m = 5;
        String [] timetable = new String [] {"08:00", "08:01", "08:02", "08:03"};
        System.out.println(solution(n,t,m,timetable));
    }
}
