package Weekely;
import java.util.*;

public class TenWeek {
    public static int getX(int [] now, int [] target){
        int upper = (now[1] * target[2]) - (now[2]*target[1]);
        int lower = (now[0] * target[1]) - (now[1] * target[0]);
        if(upper % lower == 0){
            return (int)(upper / lower);
        }else{
            return Integer.MAX_VALUE;
        }
    }
    public static int getY(int [] now, int [] target){
        long upper = ((long)(now[2]*target[0])) - ((long)(now[0]*target[2]));
        long lower = ((long)(now[0] * target[1])) - ((long)(now[1] * target[0]));
        if(upper % lower == 0){
            return (int)(upper / lower);
        }else{
            return Integer.MAX_VALUE;
        }
    }
    public static String[] solution(int[][] line) {
        int n = line.length;
        Map<Integer, ArrayList<Integer>> m = new LinkedHashMap<Integer, ArrayList<Integer>>();
        int min_x = Integer.MAX_VALUE, min_y = Integer.MAX_VALUE;
        int max_x = Integer.MIN_VALUE, max_y = Integer.MIN_VALUE;
        for(int i = 0 ; i < n; i++){
            int [] now = line[i];
            for(int j = i+1; j < n; j++){
                int [] target = line[j];
                if(((now[0] * target[1]) - (now[1]*target[0])) != 0){
                    int x= getX(now, target), y = getY(now, target);
                    if(x != Integer.MAX_VALUE && y != Integer.MAX_VALUE){
                        min_x = Math.min(min_x, x);
                        min_y = Math.min(min_y, y);
                        max_x = Math.max(max_x, x);
                        max_y = Math.max(max_y, y);
                        if(m.containsKey(y)){
                            ArrayList<Integer> al = m.get(y);
                            if(!al.contains(x)) {
                                al.add(x);
                                m.replace(y, al);
                            }
                        }else{
                            ArrayList<Integer> al = new ArrayList<Integer>();
                            al.add(x);
                            m.put(y, al);
                        }
                    }
                }
            }
        }
        int X = (max_x - min_x + 1);
        int Y = (max_y - min_y + 1);
        String [] answer = new String[Y];
        for(int i = max_y; i > max_y-Y; i--){
            if(m.containsKey(i)){
                StringBuilder sb = new StringBuilder();
                ArrayList<Integer> al = m.get(i);
                for(int y = min_x; y < min_x + X; y++){
                    if(al.contains(y)){
                        sb.append("*");
                    }else{
                        sb.append(".");
                    }
                }
                answer[(max_y-i)] = sb.toString();
            }else{
                answer[(max_y-i)] = ".".repeat(X);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String [] answers = solution(line);
        for(String answer : answers){
            System.out.println(answer);
        }
        line = new int [][] {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
        answers = solution(line);
        for(String answer : answers){
            System.out.println(answer);
        }
    }
}
