package DeliveryHero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class Pro1 {
    public static String toLower(String name){
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < name.length(); i++){
            sb2.append(Character.toLowerCase(name.charAt(i)));
        }
        return sb2.toString();
    }
    public static String getLast(String name){
        StringBuilder sb3 = new StringBuilder();
        int i = 0, count = 0;
        while(i < name.length() && count < 8){
            Character now= Character.toLowerCase(name.charAt(i));
            if(now.equals('-')){
                i += 1;
            }else{
                sb3.append(now);
                count += 1;
                i+=1;
            }
        }
        return sb3.toString();
    }
    public static String solution(String B, String C){
        String [] names = B.split(", ");
        ArrayList<String> answer = new ArrayList<String>();
        Map<String, Integer> base = new LinkedHashMap<String, Integer>();
        for(String name : names){
            StringBuilder sb = new StringBuilder();
            String [] info = name.split(" ");
            sb.append(Character.toLowerCase(info[0].charAt(0)));
            if(info.length == 2){
                sb.append(toLower(info[1]));
            }else{
                sb.append(Character.toLowerCase(info[1].charAt(0)));
                sb.append(getLast(info[2]));
            }
            String target = sb.toString();
            if(base.containsKey(target)){
                int n = base.get(target);
                base.replace(target, n+1);
                sb.append(n+1);
            }else{
                base.put(target, 1);
            }
            sb.insert(0, name + " <");

            sb.append("@").append(toLower(C)).append(".com").append(">");
            answer.add(sb.toString());
        }
        return String.join(", ", answer);
    }
    public static void main(String[] args)throws IOException{
        System.out.println(solution("John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker","Example"));
    }
}
