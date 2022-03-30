package Crema;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pro3 {
    public static class Item{
        int x, y;
        public Item(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    public static int solution(List<String> grid1, List<String> grid2){
        int answer = 0;
        int [] dx = new int [] {1,0, -1, 0};
        int [] dy = new int [] {0,1,0,-1};
        Queue<Item> q;
        int n = grid1.size();
        boolean [][] used = new boolean[n][n];
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                if(!used[x][y] && (grid1.get(x).charAt(y) == '1'|| grid2.get(x).charAt(y) == '1')){
                    boolean flag;
                    if(grid1.get(x).charAt(y) == '1' && grid2.get(x).charAt(y) == '1'){
                        flag = true;
                    }else{
                        flag = false;
                    }
                    used[x][y] = true;
                    q = new LinkedList<Item>();
                    q.add(new Item(x,y));
                    while(!q.isEmpty()){
                        Item now = q.poll();
                        for(int i = 0; i < 4; i++){
                            int nx = now.x+dx[i], ny = now.y+dy[i];
                            if(0 <= nx && nx < n && 0 <= ny && ny < n){
                                if(!used[nx][ny]){
                                    if(grid1.get(nx).charAt(ny)== '1' && grid2.get(nx).charAt(ny) == '1'){
                                        used[nx][ny] = true;
                                        q.add(new Item(nx,ny));
                                    }else if(grid1.get(nx).charAt(ny) == '1' || grid2.get(nx).charAt(ny) == '1'){
                                        used[nx][ny] = true;
                                        flag = false;
                                        q.add(new Item(nx, ny));
                                    }
                                }
                            }
                        }
                    }
                    if(flag){
                        answer += 1;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String [] Grid = new String [] {"0100",
                "1001",
                "0011",
                "0011"};
        String [] Grid2 = new String [] {"0101",
                "1001",
                "0011",
                "0011"};
        List<String> grid1 = new ArrayList<String>();
        List<String> grid2 = new ArrayList<String>();
        for(String g : Grid){
            grid1.add(g);
        }
        for(String g : Grid2){
            grid2.add(g);
        }
        System.out.println(solution(grid1, grid2));
    }
}
