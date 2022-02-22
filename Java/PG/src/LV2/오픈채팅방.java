package LV2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class 오픈채팅방 {
    public static String[] solution(String[] record){
        Map<String, String> m = new LinkedHashMap<String, String>();
        ArrayList<String> al = new ArrayList<String>();
        for(String rec : record){
            String [] now = rec.split(" ");
            if(now[0].equals("Enter")){
                m.put(now[1], now[2]);
            }else if(now[0].equals("Change")){
                m.replace(now[1], now[2]);
            }
        }
        for(int i = 0; i < record.length; i++){
            String [] now = record[i].split(" ");
            if(now[0].equals("Enter")){
                al.add(m.get(now[1])+"님이 들어왔습니다.");
            }else if(now[0].equals("Leave")){
                al.add(m.get(now[1])+"님이 나갔습니다.");
            }
        }
        String [] result = new String[al.size()];
        for(int i = 0; i < al.size(); i++){
            result[i] = al.get(i);
        }
        return result;
    }
    public static void main(String[] args){
        String [] record = new String [] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String [] answers = solution(record);
        for(String answer : answers){
            System.out.println(answer);
        }
    }
}
