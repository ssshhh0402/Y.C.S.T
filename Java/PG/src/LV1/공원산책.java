package LV1;

public class 공원산책 {

  public static int [] solution(String[] park, String [] routes){
    int [] now = new int [2];
    int n = park.length, m = park[0].length();
    int [] dx = new int [] {1,0,-1,0}, dy = new int [] {0,1,0,-1};
    for(int x = 0; x < n; x++){
      if(park[x].contains("S")){
        for(int y = 0; y < m; y++){
          if(park[x].charAt(y) == 'S'){
            now[0] = x;
            now[1] = y;
          }
        }
      }
    }
    int idx = -1;
    for(String route : routes){
      String [] data = route.split(" ");
      switch(data[0]){
        case "E": 
          idx = 1;
          break;
        case "W": 
          idx = 3;
          break;
        case "N": 
          idx = 2;
          break;
        case "S": 
          idx = 0;
          break;
      }
      int nowX = -1, nowY = -1;
      int limit = Integer.valueOf(data[1]);
      int count = 0;
      for(int i = 1; i <= limit; i++){
        nowX = now[0] + (dx[idx] * i);
        nowY = now[1] + (dy[idx] * i);
        if(nowX < 0 || nowX >= n || nowY < 0 || nowY >= m || park[nowX].charAt(nowY) == 'X'){
          break;
        }
        count += 1;
      }
      if(count == limit){
        now[0] = nowX;
        now[1] = nowY;
      }
    }
    return now;

  }
  public static void main(String[] args){
    String [] park = new String [] {"OSO","OOO","OXO","OOO"};
    String[] routes = new String [] {"E 2","S 3","W 1"};
    int [] results = solution(park, routes);
    for(int result : results){
      System.out.println(result);
    }
  }
  
}
