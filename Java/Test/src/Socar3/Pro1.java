package Socar3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Pro1 {
    static int [][] map;
    public static ArrayList<Integer> recursive(int now, int time, int n){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(time == 0){
            result.add(now);
        }else {
            for (int i = 0; i < n; i++) {
                if (map[now][i] != 0 && map[now][i] <= time) {
                    result.addAll(recursive(i, time - map[now][i], n));
                }
            }
        }
        return result;
    }
    public static int [] solution(int n, int k, int [][] roads){
        map = new int[n][n];
        for(int [] road : roads){
            int start = road[0], end = road[1], time = road[2];
            map[start][end] = time;
            map[end][start] = time;
        }
        HashSet<Integer> results = new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            if(map[0][i] != 0 && map[0][i] <= k){
                results.addAll(recursive(i, k-map[0][i], n));
            }
        }

        int [] answer;
        if(results.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[results.size()];
            int idx = 0;
            for(int result : results){
                answer[idx] = result;
                idx += 1;
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
