package TodayHoust;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pro3 {
    static int [][] map;
    static int answer, emptyRooms, X, Y;
    public static boolean checkOne(){
        return true;
    }
    public static boolean roomCheck(int x, int y, ArrayList<int[]> rooms){
        if(x+1 >= X || y+1 >= Y){
            return false;
        }else{
            for(int[] room : rooms){
                if(x == room[0] || x == room[0]+1){
                    if(y >= room[1] && y <= room[1]+1){
                        return false;
                    }
                }else if(y == room[1] || y == room[1]+1){
                    if(x >= room[0] && x <= room[0]+1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean bathCheck(int x, int y, int dir, ArrayList<int[]> rooms, ArrayList<int[]> baths){
        if(dir == 0){
            if(y+1 >= Y){
                return false;
            }
            for(int [] room : rooms){
                if(x >= room[0] && x <= room[0]+1){
                    if(y >= room[1] && y <= room[1]+1){
                        return false;
                    }else if(y >= room[1]-1 && y<= room[1]){
                        return false;
                    }
                }
            }
            for(int [] bath : baths){
                if(bath[2] == 0){
                    if(x == bath[0]) {
                        if (y >= bath[1] && y <= bath[1] + 1) {
                            return false;
                        } else if (y >= bath[1] - 1 && y <= bath[1]) {
                            return false;
                        }
                    }
                }else{
                    if(y == bath[1]){
                        if(x >= bath[0] && x <= bath[0]+1){
                            return false;
                        }else if(x >= bath[0]-1 && x <= bath[0]){
                            return false;
                        }
                    }
                }
            }
        }else{
            if(x+1 >= X){
                return false;
            }
            for(int [] room : rooms){
                if(y >= room[1] && y <= room[1]+1){
                    if(x >= room[0] && x <= room[0]+1){
                        return false;
                    }else if(x >= room[0]-1 && x <= room[0]){
                        return false;
                    }
                }
            }
            for(int [] bath : baths){
                if(bath[2] == 0){
                    if(x >= bath[0] && x <= bath[0]+1){
                        if(y >= bath[1] && y <= bath[1]+1){
                            return false;
                        }else if(y >= bath[1]-1 && y <= bath[1]){
                            return false;
                        }
                    }
                }else{
                    if(bath[1] == y){
                        if(x >= bath[0] && x <= bath[0]+1){
                            return false;
                        }else if(x >= bath[0]-1 && x <= bath[0]){
                            return false;
                        }
                    }
                }
            }
        }

       return true;
    }
    public static boolean checkTwoThree(){
        int [] dx = new int[]{0,1,0,-1};
        int [] dy = new int [] {1,0,-1,0};
        boolean [][] used = new boolean[X][Y];
        Queue<int[]> q = new LinkedList<int[]>();
        int count = 1;
        boolean checkTwo = false, checkThree = false;
        for(int a = 0; a < X; a++){
            for(int b = 0; b < Y; b++){
                if(map[a][b] == 0){
                    used[a][b] = true;
                    q.add(new int [] {a,b});
                    while(!q.isEmpty()){
                        int [] now = q.poll();
                        if(now[0] == 0 || now[0] == X-1 || now[1] == 0 || now[1] == Y-1){
                            checkThree = true;
                        }
                        for(int i = 0; i < 4; i++){
                            int x = now[0]+dx[i], y = now[1]+dy[i];
                            if(0 <= x && x < X && 0 <= y && y < Y){
                                if(!used[x][y] && map[x][y] == 0){
                                    used[x][y] = true;
                                    q.add(new int[]{x,y});
                                    count += 1;
                                }
                            }
                        }
                    }
                    if(count == emptyRooms){
                        checkTwo = true;
                        break;
                    }else{
                        break;
                    }
                }
            }
        }
        return checkTwo && checkThree;
    }
    public static void recursive(int room, int bath, ArrayList<int[]> rooms, ArrayList<int[]> baths){
        if(room == 0){
            if(bath == 0){
                if(checkOne() && checkTwoThree()){
                    answer += 1;
                }
            }else{
                for(int x = 0; x < X; x++){
                    for(int y = 0; y < Y; y++){
                        for(int i = 0; i < 2; i++){
                            if(bathCheck(x,y,i,rooms,baths)){
                                baths.add(new int[]{x,y,i});
                                recursive(room, bath-1, rooms, baths);
                                baths.remove(baths.size()-1);
                            }
                        }
                    }
                }
            }
            return;
        }
        for(int x= 0; x < X; x++){
            for(int y = 0; y < Y; y++){
                if(roomCheck(x,y, rooms)){
                    rooms.add(new int [] {x,y});
                    recursive(room-1, bath, rooms, baths);
                    rooms.remove(rooms.size()-1);
                }
            }
        }
    }
    public static int solution(int n, int m, int room, int bath){
        answer = 0;
        X = n;
        Y = m;
        map = new int [n][m];
        emptyRooms = (n * m) - 4 * room - 2 * bath;
        ArrayList<int [] > rooms = new ArrayList<int[]>();
        ArrayList<int[]> baths = new ArrayList<int[]>();
        recursive(room, bath, rooms, baths);
        return answer;
    }
    public static void main(String[] args){
        int n = 4;
        int m = 5;
        int room = 3;
        int bath = 1;

        System.out.println(solution(n,m,room, bath));
    }
}
