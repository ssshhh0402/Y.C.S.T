package Socar3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Pro1_2 {
    public static int [] solution(int n, int k, int [][] roads){
        ArrayList<int [] >[] map = new ArrayList[n];
        for(int i = 0; i < n; i++){
            map[i] = new ArrayList<int[]>();
        }
        for(int [] road : roads){
            int start = road[0], end = road[1], time = road[2];
            map[start].add(new int [] {end, time});
            map[end].add(new int [] {start, time});
        }
        HashSet<Integer> results = new HashSet<Integer>();
        Queue<int [] > q = new LinkedList<int [] >();
        q.add(new int [] {0, k});
        while(!q.isEmpty()){
            int [] now = q.poll();                              // now = {현재 위치, 남은 시간}
            if(now[1] == 0){
                results.add(now[0]);
            }else if(now[1] > 0){
                for(int[] next : map[now[0]]){
                    q.add(new int [] {next[0], now[1] - next[1]});
                }
            }
        }
        int [] answer;
        if(results.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer=  new int[results.size()];
            int idx = 0;
            for(int result : results){
                answer[idx] = result;
                idx+=1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int n = 6;
        int k = 17;
        int [][] roads = new int [][] {{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}};
        int [] answers = solution(n,k,roads);
        for(int answer : answers){
            System.out.println(answer);
        }
        n = 4;k = 10;
        roads = new int [][] {{0, 1, 2}, {0, 2, 3}};
        answers = solution(n,k,roads);
        for(int answer : answers){
            System.out.println(answer);
        }
        n = 4; k = 11;
        roads = new int [][]{{0, 1, 2}, {1, 2, 7}, {2, 3, 10}, {3, 0, 9}};
        answers = solution(n,k,roads);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
