package Trenbe;

public class Pro2_2 {
    public static long convert(String p){
        String [] ps = p.split(" ");
        long time = 0;
        String [] times = ps[1].split(":");
        for(int i = 0; i < times.length; i++){
            time += Integer.parseInt(times[i]) * Math.pow(60,2-i);
        }
        if(ps[0].equals("PM")){
            time += 12 * Math.pow(60,2);
        }
        return time;
    }
    public static String [] lToS(long time){
        String [] result = new String[3];
        for(int i = 0; i < 3; i++){
            int sec = (int)Math.pow(60, 2-i);
            int target = (int)(time / sec);
            time %= sec;
            if( i == 0 && target >= 24){
                target -= 24;
            }
            if(target < 10){
                result[i] = "0"+String.valueOf(target);
            }else{
                result[i] = String.valueOf(target);
            }
        }
        return result;
    }
    public static String solution(String p, int N){
        long time = convert(p);
        time += N;
        String [] result = lToS(time);
        return String.join(":", result);
    }
    public static void main(String[] args){
        String p;
        int N;
//        String p = "PM 01:00:00";
//        int N = 10;

        p = "AM 11:59:59";
        N = 1;
        System.out.println(solution(p,N));
        p = "PM 01:36:50";
        N = 10;
        System.out.println(solution(p,N));
        p = "PM 11:59:59";
        N = 1;
        System.out.println(solution(p,N));
    }
}
