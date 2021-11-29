package Trenbe;

public class Pro2 {
    public static String [] getAnswer(int[] time, int N){
        String [] result = new String[3];
        time[2] += N;
        for(int i = 2; i >= 0; i--){
            if(i == 0){
                time[i] %= 24;
            }else {
                time[i - 1] += time[i] / 60;
                time[i] %= 60;
            }
            if(time[i] < 10){
                result[i] = "0"+String.valueOf(time[i]);
            }else{
                result[i] = String.valueOf(time[i]);
            }
        }
        return result;
    }
    public static int [] getTime(String p){
        String [] now = p.split(" ");
        String p_type = now[0];
        String[] p_time = now[1].split(":");
        int [] times = new int[3];
        for(int i = 0; i < 3; i++){
            times[i] = Integer.parseInt(p_time[i]);
        }
        if(p_type.equals("AM") && times[0] == 12){
            times[0] = 0;
        }else if(p_type.equals("PM") && times[0] < 12){
            times[0] += 12;
        }
        return times;
    }
    public static String solution(String p, int n){
        int [] time = getTime(p);
        String [] answer = getAnswer(time, n);
        return String.join(":", answer);
    }
    public static void main(String[] args){
        String p;
        int N;
//        String p = "PM 01:00:00";
//        int N = 10;
        p = "PM 11:59:59";
        N = 1;
        p = "AM 11:59:59";
        N = 1;
        System.out.println(solution(p,N));
    }
}
