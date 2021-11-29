package Beat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pro1 {
    public static Map<Boolean, ArrayList<int[]>> initMap(){
        Map<Boolean, ArrayList<int[]>> m = new LinkedHashMap<Boolean, ArrayList<int[]>>();
        ArrayList<int[]> al = new ArrayList<int[]>();
        al.add(new int [] {0,1});
        al.add(new int [] {-1,0});
        m.put(true, al);
        al = new ArrayList<int [] >();
        al.add(new int [] {1,0});
        al.add(new int [] {0,-1});
        m.put(false, al);
        return m;

    }
    public static int [][] solution(int n, boolean horizontal){
        int [][] base = new int[n][n];
        int value = 1;
        int count = 0;
        int x = 0, y = 0;
        Map<Boolean, ArrayList<int[]>> m = initMap();
        while(value <= n*n){
            base[x][y] = value;
            value += 1;
            ArrayList<int[]> dirs = m.get(horizontal);
            int [] dir = dirs.get(0);
            for(int i = 0; i < count; i++){
                x += dir[0];
                y += dir[1];
                base[x][y] = value;
                value+=1;
            }
            dir = dirs.get(1);
            for(int i = 0; i < count; i++){
                x += dir[0];
                y += dir[1];
                base[x][y] = value;
                value += 1;
            }
            dir = dirs.get(0);
            x += dir[0];
            y += dir[1];
            count += 1;
            horizontal = !horizontal;
        }
        return base;
    }
    public static void main(String[] args){
        int n = 4;
        boolean horizontal = true;
        Map<Boolean, ArrayList<int[]>> m = initMap();
        int [][] answers = solution(n, horizontal);
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                System.out.print(answers[x][y] + " ");
            }
            System.out.println("");
        }
    }
}
