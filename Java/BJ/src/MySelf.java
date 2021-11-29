import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class MySelf {
    public static String timeConversion(String s){
        String answer = "";
        String[] times = s.substring(0,s.length()-2).split(":");
        int time = Integer.parseInt(times[0]);
        String type = s.substring(s.length()-2, s.length());
        if(type.equals("PM")){
            if(time != 12){
                time += 12;
            }
        }else{
            if(time == 12){
                time -= 12;
            }
        }
        if(time < 10){
            times[0] = "0"+String.valueOf(time);
        }else{
            times[0] = String.valueOf(time);
        }
        answer = String.join(":",times);
        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String time = br.readLine();
        System.out.println(timeConversion(time));
    }
}
