package LV1;

import java.util.LinkedHashMap;
import java.util.Map;

public class 달리기경주 {

  public static String [] solution(String[] players, String[] callings){
    int n = players.length;
    Map<String, Integer> rate = new LinkedHashMap<String, Integer>();
    for(int i = 0; i < n; i++){
      rate.put(players[i], i);
    }
    for(String calling : callings){
      int now = rate.get(calling);
      rate.replace(calling, now-1);
      String name = players[now-1];
      rate.replace(name, now);
      players[now-1] = calling;
      players[now] = name;
    }
    return players;
  }
  public static void main(String[] args){
    String [] players = new String [] {"mumu","soe","poe","kai","mine"};
    String [] callings = new String [] {"kai","kai","mine","mine"};
    String [] results = solution(players, callings);
    for(String result : results){
      System.out.println(result);
    }

  }
  
}
