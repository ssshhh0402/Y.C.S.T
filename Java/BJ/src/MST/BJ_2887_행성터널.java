package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2887_행성터널 {
    static class Point{
        int x, y, z;

        Point(int a, int b, int c){
            this.x = a;
            this.y = b;
            this.z = c;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Point> q = new LinkedList<Point>();
        int N = Integer.parseInt(br.readLine());
        String [] inputs;
        for(int i = 0; i < N; i++){
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]), y = Integer.parseInt(inputs[1]), z = Integer.parseInt(inputs[2]);
            q.add(new Point(x,y,z));
        }
    }
}
