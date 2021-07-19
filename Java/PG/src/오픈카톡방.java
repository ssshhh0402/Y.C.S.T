import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class 오픈카톡방 {
    public static String [] solution(String[] record){
        Map<String, String> names = new LinkedHashMap<String, String>();
        ArrayList<String> sb = new ArrayList<String>();
        for(String rec : record){
            String [] inputs = rec.split(" ");
            if(inputs[0].equals("Enter")){
                names.put(inputs[1], inputs[2]);
            }else if(inputs[0].equals("Change")){
                names.replace(inputs[1], inputs[2]);
            }
        }
        for(String rec : record){
            String[] inputs = rec.split(" ");
            if (inputs[0].equals("Enter")) {
                sb.add(names.get(inputs[1])+ "님이 들어왔습니다");
            }else if(inputs[0].equals("Leave")){
                sb.add(names.get(inputs[1]) + "님이 나갔습니다");
            }
        }
        String [] answers = new String[sb.size()];
        for(int i = 0; i < sb.size(); i++){
            answers[i] = sb.get(i);
        }
        return answers;
    }
    public static void main(String[] args){
        String [] answers = solution(new String [] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        for(String answer : answers){
            System.out.println(answer);
        }
    }
}
