package LV3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 리틀프렌즈사천성 {
    static boolean [][] visited;
    static String [][] boards;
    static ArrayList<String> answers;
    static int [] dx = new int [] {0,1,0,-1};
    static int [] dy = new int [] {1,0,-1,0};
    static class Item{
        int x, y;
        boolean flag;

        Item(int a, int b){
            this.x = a;
            this.y = b;
            this.flag = false;
        }
    }
    public static boolean isPossible(int x, int y){
        Queue<Item> q = new LinkedList<Item>();

        q.add(new Item(x,y));
        String target = boards[x][y];
        return true;
    }
    public static void find(int count, String route){
        if(count == 0){
            answers.add(route);
            return;
        }

    }
    public static String solution(int m, int n, String[] board){
        visited = new boolean[m][n];
        boards = new String[m][n];
        int count = 0;
        for(int x = 0; x < m; x++){
            String [] now = board[x].split("");
            for(int y = 0; y < n; y++){
                boards[x][y] = now[y];
                if(!now[y].equals(".") && !now[y].equals("*")){
                    count += 1;
                }
            }
        }
        if(count % 2 != 0){
            return "IMPOSSIBLE";
        }
        answers = new ArrayList<String>();
        for(int x = 0; x < m; x++){
            for(int y = 0; y < n; y++){
                if(!boards[x][y].equals("*") && !boards[x][y].equals(".")){
                    if(isPossible(x,y)){
                        visited[x][y] = true;
                        find(count-2, boards[x][y]);
                    }
                }
            }
        }
        if(answers.size() == 0){
            return "IMPOSSIBLE";
        }else{
            Collections.sort(answers);
            return answers.get(0);
        }
    }
    public static void main(String[] args){
        int m = 3;
        int n = 3;
        String [] board = new String [] {"DBA", "C*A", "CDB"};
        System.out.println(solution(m,n,board));
    }
}
