package Dev_Game;

import java.util.ArrayList;
import java.util.Collections;

public class Pro2 {
    static int answer;
    static ArrayList<Pair > al;
    public static class Pair implements Comparable<Pair>{
        int x, y;

        Pair(int a, int b){
            this.x = a;
            this.y = b;
        }

        public int compareTo(Pair p){
            if(this.y == p.y){
                return this.x - p.x;
            }else{
                return this.y - p.y;
            }
        }


    }
    static int [] dx = new int [] {-1,-1,0,1,-1,0,1,1}, dy = new int [] {0,1,1,-1,1,-1,-1,0};
    public static void recursive(int a, int b, String[] board, int dir){
        int x = a+dx[dir], y = b + dy[dir];
        if(0 <= x && x < board.length && 0 <= y && y < board[0].length()){
            if(board[x].charAt(y) == '1'){
                al.add(new Pair(x, y));
                recursive(x,y,board, dir);
            }
        }
    }
    public static int solution(int h, int w, int n, String [] board){
        ArrayList<String> answers = new ArrayList<String>();
        for(int x = 0; x < h; x++){
            for(int y = 0; y < w; y++){
                if(board[x].charAt(y) == '1'){
                    for(int i = 0; i < 4; i++){
                        int a = x+dx[i], b = y+dy[i], c = x + dx[7-i], d = y+dy[7-i];
                        if(0 <= a && a < h && 0 <= b && b < w && 0 <= c && c < h && 0 <= d && d < w){
                            al = new ArrayList<Pair>();
                            al.add(new Pair(x, y));
                            if(board[a].charAt(b) == '1'){
                                al.add(new Pair(a, b));
                                recursive(a,b,board, i);
                            }
                            if(board[c].charAt(d) == '1'){
                                al.add(new Pair(c, d));
                                recursive(c, d, board, 7-i);
                            }
                            if(al.size() == n){
                                String temps = "";
                                Collections.sort(al);
                                for(Pair item : al){
                                    temps += (String.valueOf(item.x)+String.valueOf(item.y));
                                }
                                if(!answers.contains(temps)){
                                    answers.add(temps);
                                }
                            }
                        }

                    }
                }
            }
        }
        return answers.size();
    }
    public static void main(String[] args){
        int h = 7;
        int w = 9;
        int n = 4;
        String [] board = new String [] {"111100000","000010011","111100011","111110011","111100011","111100010","111100000"};
        System.out.println(solution(h,w,n,board));
    }
}
