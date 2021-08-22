package Grab2021;

import java.util.ArrayList;
import java.util.List;

public class Pro3_2 {
    static int answer;
    static int n, m;
    static boolean [] usedX, usedY;
    static ArrayList<String> routes = new ArrayList<String>();

    static class Position{
        int x, y;

        Position(int a, int b){
            this.x = a;
            this.y = b;
        }

    }

    public static String change(List<Position> now){
        StringBuilder sb = new StringBuilder();
        for(Position n : now){
            sb.append(n.x).append(n.y).append(",");
        }
        return sb.toString();
    }
    public static boolean containCheck(ArrayList<String> routes, String now){
        String [] now_s = now.split(",");
        for(String route : routes){
            int count = 0;
            boolean [] used = new boolean[now_s.length];
            String [] route_s = route.split(",");
            for(int x = 0; x < now_s.length; x++) {
                for (int y = 0; y < now_s.length; y++) {
                    if(now_s[x].equals(route_s[y]) && !used[y]){
                        count += 1;
                        used[y] = true;
                    }
                }
            }
            if(count == now_s.length){
                return false;
            }
        }
        return true;
    }
    public static void find(String word, String[] cards, int count, ArrayList<Position> now, String testing) {
        if (count == n) {
            String tempting = change(now);
            if (containCheck(routes,tempting)) {
                routes.add(tempting);
                answer += 1;
            }
            return;
        }
        char target = word.charAt(count);
        for (int x = 0; x < m; x++) {
            if (!usedX[x]) {
                for (int y = 0; y < m; y++) {
                    if (!usedY[y]) {
                        if (cards[x].charAt(y) == target) {
                            usedX[x] = true;
                            usedY[y] = true;
                            now.add(new Position(x, y));
                            find(word, cards, count + 1, now, testing + String.valueOf(target));
                            usedX[x] = false;
                            usedY[y] = false;
                            now.remove(now.size() - 1);
                        }
                    }
                }
            }
        }
    }

    public static int solution(String word, String[] cards){
        n = word.length();
        m = cards.length;
        answer = 0;
        usedX = new boolean [m];
        usedY = new boolean [m];
        char target = word.charAt(0);
        for(int x = 0; x < m; x++){
            for(int y = 0; y < m; y++){
                if(cards[x].charAt(y) == target){
                    ArrayList<Position> now = new ArrayList<>();
                    usedX[x] = true;
                    usedY[y] = true;
                    now.add(new Position(x,y));
                    find(word,cards,1, now, String.valueOf(target));
                    usedX[x] = false;
                    usedY[y] = false;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String word = "APPLE";
        String [] cards = {"LLZKE", "LCXEA","CVPPS","EAVSR","FXPFP"};
        System.out.println(solution(word, cards));
        word = "BAB";
        cards = new String[] {"ZZBZ", "BAZB","XBXB","XBAX"};
        System.out.println(solution(word, cards));
        word = "BABXZ";
        cards = new String[] {"ZZBZ", "BAZB","XBXB","XBAX"};
        System.out.println(solution(word,cards));

    }
}
