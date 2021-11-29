package Silicon;

import java.util.ArrayList;

public class Pro1 {
    static class Point{
        int x, y;

        Point(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    public static int [] solution(int rows, int columns, int[][] connections, int[][]queries){
        int [] answer = new int[queries.length];
        ArrayList<Point>[][] al = new ArrayList[rows+1][];
        for(int x = 1; x < rows+1; x++){
            al[x] = new ArrayList[columns+1];
            for(int y = 1; y < columns+1; y++){
                al[x][y] = new ArrayList<Point>();
            }
        }
        for(int [] connection : connections){
            int x1=connection[0],y1=connection[1],x2=connection[2],y2=connection[3];
            al[x1][y1].add(new Point(x2,y2));
            al[x2][y2].add(new Point(x1,y1));
        }
        for(int i = 0 ; i < queries.length; i++){
            int count = 0;
            int [] query = queries[i];
            int x1=query[0],y1=query[1],x2=query[2],y2=query[3];
            int min_x = Math.min(x1,x2), max_x = Math.max(x1,x2);
            int min_y = Math.min(y1,y2), max_y = Math.max(y1,y2);
            for(int x = min_x; x < max_x+1; x++){
                for(int y = min_y; y < max_y+1; y++){
                    if(al[x][y].size() != 0){
                        Point now = new Point(x,y);
                        ArrayList<Point > remove = new ArrayList<Point>();
                        for(Point p : al[x][y]){
                            if(p.x < min_x || p.x > max_x || p.y < min_y || p.y > max_y){
                                remove.add(p);
                            }
                        }
                        count += remove.size();
                        for(Point p : remove){
                            for(int j = 0; j < al[x][y].size();j++){
                                Point target = al[x][y].get(j);
                                if(target.x == p.x && target.y == p.y){
                                    al[x][y].remove(j);
                                    break;
                                }
                            }
                            for(int j = 0 ; j < al[p.x][p.y].size(); j++){
                                Point target = al[p.x][p.y].get(j);
                                if(target.x == x && target.y == y){
                                    al[p.x][p.y].remove(j);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            answer[i] = count;
        }
        return answer;
    }
    public static void main(String[] args){
        int rows = 4;
        int columns = 3;
        int [][] connections = new int [][]{{1,1,2,1},{1,2,1,3},{1,3,2,3},{2,2,2,3},{2,2,3,2},{2,3,3,3},{3,2,3,3},{3,2,4,2},{4,1,4,2}};
        int [][] queries = new int [][] {{2,2,3,1},{1,2,4,2}};
        int [] answers = solution(rows, columns, connections,queries);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
