package Weekely;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TenWeek {
    public static int getX(int [] now, int [] target){
        int upper = (now[1] * target[2]) - (now[2]*target[1]);
        int lower = (now[0] * target[1]) - (now[1] * target[0]);
        if(upper % lower == 0){
            return upper / lower;
        }else{
            return Integer.MAX_VALUE;
        }
    }
    public static int getY(int [] now, int [] target){
        int upper = (now[2]*target[0]) - (now[0]*target[2]);
        int lower = (now[0] * target[1]) - (now[1] * target[0]);
        if(upper % lower == 0){
            return upper / lower;
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
                        if(m.containsKey(x)){
                            ArrayList<Integer> al = m.get(x);
                            al.add(y);
                            m.replace(x, al);
                        }else{
                            ArrayList<Integer> al = new ArrayList<Integer>();
                            al.add(y);
                            m.put(x, al);
                        }
                    }
                }
            }
        }
        int N = Math.max(max_x-min_x+1, max_y - min_y+1);
        String [][] answer = new String[N][N];
        String [] answers = new String[N];
        for(int i = 0 ; i < N; i++){
            Arrays.fill(answer[i], ".");
            if(m.containsKey(i+min_x)){
                StringBuilder sb = new StringBuilder();
                ArrayList<Integer> al = m.get(i+min_x);
                for(int y = 0; y < N; y++){
                    if(al.contains(al)){
                        sb.append("*");
                    }else{
                        sb.append(".");
                    }
                }
                answers[i] = sb.toString();
            }else{
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < N; j++){
                    sb.append(".");
                }
                answers[i] = sb.toString();
            }
        }
//        for(int i = 0 ; i < al.size(); i++){
//            int [] now = al.get(i);
//            answer[now[0]+min_x][now[1]+min_y]= "*";
//        }
//        for(int i = 0 ; i < N; i++){
//            StringBuilder sb = new StringBuilder();
//            for(int y = 0; y < N; y++){
//                if(!answer[i][y].equals("*")){
//                    sb.append(".");
//                }else{
//                    sb.append("*");
//                }
//            }
//            answers[i] = sb.toString();
//        }
        return answers;
    }
    public static void main(String[] args){
        int [][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String [] answers = solution(line);
        for(String answer : answers){
            System.out.println(answer);
        }
    }
}
