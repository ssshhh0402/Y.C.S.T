import java.util.*;

public class Pro7 {
    public static List<String> preprocessDate(List<String> dates){
        List<String> base = new LinkedList<String>();
        Map<String,Integer> months = new HashMap<String, Integer>();
        String[] month = new String[] {"","Jan","Feb","Mar", "Apr", "May", "Jun", "Jul","Aug","Sep","Oct","Nov","Dec"};
        for(int i = 1; i < 13; i++){
            months.put(month[i], i);
        }
        String[] inputs;
        String[] days;
        StringBuilder sb;
        for(String date : dates){
            sb = new StringBuilder();
            inputs = date.split(" ");
            sb.append(inputs[2]+"-");
            int mon = months.get(inputs[1]);
            if(mon < 10){
                sb.append("0"+mon + "-");
            }else{
                sb.append(mon + "-");
            }
            days = inputs[0].split("th|nd|st");
            if(days[0].length() == 1){
                sb.append("0"+days[0]);
            }else{
                sb.append(days[0]);
            }
            base.add(sb.toString());
        }
        return base;
    }
    public static void main(String[] args){
        List<String> base = new LinkedList<String>();
        String[] temps = new String[] {"20th Oct 2052", "6th Jun 1933", "26th May 1960", "20th Sep 1958", "16th Mar 2068", "25th May 1912", "16th Dec 2018","6th Jun 1933","26th Dec 2061", "4th Nov 2030", "28th Jul 1963"};
        for(String item : temps){
            base.add(item);
        }
        System.out.println(preprocessDate(base));
    }
}
