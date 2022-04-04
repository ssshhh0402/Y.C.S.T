package DevMat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Pro1 {
    static int n;
    static ArrayList<int[]> answers;
    static boolean [] used;
    static int [][] map;
    public static boolean isPossible(int [] route, int [] costs){
        for(int x = 0; x < n; x++){
            if(route[x] ==-1){
                break;
            }
            for(int y =  x+1; y < n; y++){
                if(route[y] == -1){
                    break;
                }
                int from = route[x], to = route[y];
                int cost = costs[y] - costs[x];
                if(cost != map[from][to]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void recursive(int now, int[] route, int [] costs){
        if(now == n){
            answers.add(Arrays.copyOf(route, n));
            return;
        }
        int before = route[now-1];
        for(int y = 0; y < n;y++){
            if(!used[y]){
                used[y] = true;
                route[now] = y;
                costs[now] = costs[now-1]+map[before][y];
                if(isPossible(route, costs)) {
                    recursive(now + 1, route, costs);
                }
                used[y] = false;
                route[now] = -1;
                costs[now] = 0;
            }
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(3);
        al.add(2);
    }
    public static int [][] solution(int [][] dist){
        n = dist.length;
        answers = new ArrayList<int[]>();
        map = dist;
        used = new boolean[n];
        int [] route = new int[n];
        int [] costs = new int[n];
        Arrays.fill(route, -1);
        for(int i = 0; i < n; i++){
            route[0] = i;
            used[i] = true;
            recursive(1, route, costs);
            used[i] = false;
        }
        int [][] answer = new int [answers.size()][n];
        for(int i = 0; i < answers.size(); i++){
            int [] now = answers.get(i);
            for(int y = 0; y < now.length; y++){
                answer[i][y] = now[y];
            }
        }
        return answer;
    }
    public static void recursive2(int now, int[] route, int [] costs){
        if(now == n){
            if(isPossible(route, costs)) {
                answers.add(Arrays.copyOf(route, n));
            }
            return;
        }
        int before = route[now-1];
        for(int y = 0; y < n;y++){
            if(!used[y]){
                used[y] = true;
                route[now] = y;
                costs[now] = costs[now-1]+map[before][y];
                recursive2(now+1, route, costs);
                used[y] = false;
                route[now] = -1;
                costs[now] = 0;
            }
        }
    }
    public static int [][] solution2(int [][] dist){
        n = dist.length;
        answers = new ArrayList<int[]>();
        map = dist;
        used = new boolean[n];
        int [] route = new int[n];
        int [] costs = new int[n];
        Arrays.fill(route, -1);
        for(int i = 0; i < n; i++){
            route[0] = i;
            used[i] = true;
            recursive2(1, route, costs);
            used[i] = false;
        }
        int [][] answer = new int [answers.size()][n];
        for(int i = 0; i < answers.size(); i++){
            int [] now = answers.get(i);
            for(int y = 0; y < now.length; y++){
                answer[i][y] = now[y];
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [][] dist = new int [][] {{0,5,2,4,1},{5,0,3,9,6},{2,3,0,6,3},{4,9,6,0,3},{1,6,3,3,0}};
        System.out.println("---------------- Test 1 시작-------------");
        long start = System.currentTimeMillis();
        int [][] answers = solution(dist);
        for(int [] answer: answers){
            for(int a : answer){
                System.out.print(a + " ");
            }
            System.out.println("");
        }
        System.out.println("---------------- Test 1 종료 시간-------------");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("------------------------------------");
        System.out.println("---------------- Test 2 시작-------------");
        start = System.currentTimeMillis();
        answers = solution2(dist);
        for(int [] answer : answers){
            for(int a : answer){
                System.out.print(a + " ");
            }
            System.out.println("");
        }
        System.out.println("----------------Test2 종료 시간-------------");
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("------------------------------------------");
    }
}
