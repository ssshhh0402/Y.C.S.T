package LV1;

import java.util.LinkedHashMap;
import java.util.Map;

public class 추억점수 {
  public static int [] solution(String [] name, int [] yearning, String [][] photo){
    int [] answer;
    int n = photo.length;
    answer = new int [n];
    Map<String, Integer> scores = new LinkedHashMap<String, Integer>();
    for(int i = 0 ; i < name.length; i++){
      scores.put(name[i], yearning[i]);
    }
    int score;
    for(int i = 0; i < n; i++){
      score = 0;
      String [] names = photo[i];
      for(String user : names){
        if(scores.containsKey(user)){
          score += scores.get(user);
        }
      }
      answer[i] = score;
    }
    return answer;
  }
  public static void main(String[] args){
    String [] name = new String [] {"may", "kein", "kain", "radi"};
    int [] yearning = new int [] {5,10,1,3};
    String [][] photo = new String [][] {{"may","kein","kain","radi"},{"may","kein","brin","deny"},{"kon","kain","may","coni"}};
    int [] result = solution(name,yearning,photo);
    for(int rData : result){
      System.out.println(rData);
    }
  }
}
