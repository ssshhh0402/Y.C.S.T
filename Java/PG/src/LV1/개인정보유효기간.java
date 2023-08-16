package LV1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class 개인정보유효기간 {

  public static int [] solution(String today, String [] terms, String [] privacies){
    int [] answer = {};
    List<Integer> results = new ArrayList<Integer>();
    String [] todays = today.split(".");
    int year = Integer.parseInt(todays[0]), month = Integer.parseInt(todays[1]), day = Integer.parseInt(todays[2]);
    Map<String, Integer> term = new LinkedHashMap<String, Integer>();
    for(String data : terms){
      String [] datas = data.split(" ");
      if(term.containsKey(datas[0])){
        term.replace(datas[0], 22 * Integer.parseInt(datas[1]));
      }else{
        term.put(datas[0], 22 * Integer.parseInt(datas[1]));
      }
    }
    for(int i = 0; i < privacies.length; i++){
      String privacy = privacies[i];
      
    }
    return answer;
  }
  public static void main(String[] args){
    String today = "2022.05.19";
    String [] terms = new String [] {"A 6", "B 12", "C 3"};
    String [] privacies = new String [] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
    int [] result = solution(today ,terms ,privacies);
    for(int data : result){
      System.out.println(data);
    }
  }
  
}
