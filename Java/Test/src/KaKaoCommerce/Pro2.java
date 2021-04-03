package KaKaoCommerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Pro2 {
    static int RobotMax, answer;
    static ArrayList<Integer>[] base;
    static ArrayList<Integer> robots;
    public static int counting(){
        int count = 0;
        for(ArrayList<Integer> now : base){
            if(now.size() > robots.size()){
                break;
            }
            if (now.equals(robots)){
                count += 1;
            }
        }
        return count;
    }
    public static void find(int idx, int r, int sum){
        if(r == RobotMax){
            answer= Math.max(answer, sum);
            return;
        }
        for(int i = idx+1; i < base.length; i++){
            robots.add(i);
            int count = counting();
            find(i, r+1, sum + count);
            robots.remove(robots.size()-1);
        }
    }
    public static int solution(int [][] needs, int r){
        answer = 0;
        robots = new ArrayList<Integer>();
        RobotMax = r;
        int N = needs.length;
        base = new ArrayList[N];
        for(int i = 0; i < N; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int x = 0; x < N; x++){
            for(int y = 0; y < needs[x].length; y++){
                if(needs[x][y] == 1){
                    base[x].add(y);
                }
            }
        }
        Arrays.sort(base, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> t1, ArrayList<Integer> t2){
                return t1.size() - t2.size();
            }
        });
        for(int i = 0; i < N; i++){
            robots.add(i);
            int count = counting();
            find(i, 1, count);
            robots.remove(0);
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(new int [][] {{1,0,0},{1,1,0},{1,1,0},{1,0,1},{1,1,0},{0,1,1}},2));
    }
}
