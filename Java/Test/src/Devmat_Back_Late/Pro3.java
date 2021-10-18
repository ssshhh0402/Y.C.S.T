package Devmat_Back_Late;
import java.util.*;
public class Pro3 {
    static int [][] base;
    static class Pair{
        int x, y;

        Pair(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    public static ArrayList<Pair> getRemove(int x, int y, int color){
        Queue<Pair> q = new LinkedList<Pair>();
        ArrayList<Pair> result = new ArrayList<Pair>();
        boolean [][] used = new boolean[7][7];
        int [] dx = new int[]{-1,0,1,0};
        int [] dy = new int []{0,1,-1,0};
        q.add(new Pair(x,y));
        used[x][y] = true;
        result.add(new Pair(x, y));
        while(!q.isEmpty()){
           Pair now = q.poll();
           for(int i = 0 ; i < 4; i++){
               int a = now.x+dx[i], b = now.y+dy[i];
               if(0 <= a && a < 7 && 0 <= b && b < 7){
                   if(!used[a][b] && base[a][b] == color){
                       used[a][b] = true;
                       q.add(new Pair(a,b));
                       result.add(new Pair(a, b));
                   }
               }
           }
        }
        return result;
    }
    public static Map<Integer, ArrayList<Integer>> getMap(ArrayList<Pair> items){
        Map<Integer, ArrayList<Integer>> result = new LinkedHashMap<Integer, ArrayList<Integer>>();
        for(Pair item : items){
            if(result.containsKey(item.x)){
                ArrayList<Integer> al = result.get(item.x);
                al.add(item.y);
                result.replace(item.x, al);
            }else{
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(item.y);
                result.put(item.x, al);
            }
        }
        return result;
    }
    public static String [] solution(int [][] macaron){
        base = new int[7][7];
        int [] height = new int[7];
        for(int i = 0 ; i < macaron.length;i++){
            int y = macaron[i][0], color = macaron[i][1];
            base[6-height[y]][y] = color;
            height[y] += 1;
            ArrayList<Pair> removed = getRemove(7-height[y],y, color);
            if(removed.size() >= 4){
                for(Pair now : removed){
                    int a = now.x, b = now.y;
                }
            }
        }
        String [] answer = new String[6];
        for(int i =0 ; i < 6; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j < 7; j++){
                sb.append(base[i+1][j]);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    public static void main(String[] args){
        int [][] macaron = {{1, 1}, {2, 1}, {1, 2}, {3, 3}, {6, 4}, {3, 1}, {3, 3}, {3, 3}, {3, 4}, {2, 1}};
        String [] answers = (solution(macaron));
        for(String answer : answers) {
            System.out.println(answer);
        }
    }
}
