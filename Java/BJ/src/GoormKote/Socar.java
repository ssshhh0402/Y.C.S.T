package GoormKote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Socar {
    static class time{
        long start, end;
        time(long a, long b){
            this.start = a;
            this.end = b;
        }

    }
    public static long convert(String time){
        String[] temps = time.split(":");
        long hour = 60 * (Integer.parseInt(temps[0]));
        long minutes = Long.parseLong(temps[1]);
        return hour + minutes;
    }
    public static String convert_v(long time){
        int hour = (int)time / 60;
        int minutes = (int)time % 60;
        String s_hour, s_minutes;
        if(hour < 10){
            s_hour = "0" + String.valueOf(hour);
        }else{
            s_hour = String.valueOf(hour);
        }
        if(minutes < 10){
            s_minutes = "0" + String.valueOf(minutes);
        }else{
            s_minutes = String.valueOf(minutes);
        }
        return s_hour + ":" + s_minutes;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs;
        int [] counts = new int[(int)convert("23:59")+1];
        ArrayList<time> base = new ArrayList<time>();
        for(int i = 0; i < N; i++){
            inputs = br.readLine().split("~ | ");
            long start = convert(inputs[0]);
            long end = convert(inputs[2]);
            base.add(new time(start, end));
        }
        String answer = "";
        long min_start = Long.MAX_VALUE;
        long max_end = Long.MAX_VALUE;
        long start = 0;
        long end = 0;
        int count = 0;
        for(int i = 0; i < N; i++){
            time target = base.get(i);
            for(long j = target.start; j< target.end+1; j++){
                counts[(int)j] += 1;
            }
            if(target.start < min_start){
                min_start = target.start;
            }
            if(target.end < max_end){
                max_end = target.end;
            }
        }
        for(long i = min_start; i< max_end+1; i++){
            if(counts[(int)i] > count){
                count = counts[(int)i];
                start = i;
            }else if(counts[(int)i] == count){
                end = i;
            }
        }
        answer = convert_v(start) + " : " + convert_v(end);

        if(count != N){
            System.out.println("-1");
        }else{
            System.out.println(answer);
        }
    }
}
