package Socar3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Pro1_4 {
    static int [][] map;
    public static ArrayList<Integer> recursive(int now, int k, int n){
        ArrayList<Integer> results = new ArrayList<Integer>();
        if(k == 0){
            results.add(now);
        }else{
            for(int z = 0; z < n; z++){
                for(int y = 0; y < n; y++){
                    if(z != y){
                        int leftTime = k - map[now][z] - map[z][y];
                        if(leftTime >= 0){
                            ArrayList<Integer> result = recursive(y, leftTime, n);
                            for(int data : result){
                                if(!results.contains(data)){
                                    results.add(data);
                                }
                            }
                        }
                    }
                }
            }
        }
        return results;
    }
    public static int[] solution(int n, int k, int [][] roads){
        map = new int[n][n];
        for(int i = 0 ; i < n; i++){
            Arrays.fill(map[i], 200001);
            map[i][i] = 0;
        }
        for(int [] road : roads){
            int start = road[0], end = road[1], time = road[2];
            map[start][end] = time;
            map[end][start] = time;
        }
        for(int z = 0; z < n; z++){
            for(int x = 0; x < n; x++){
                for(int y = 0; y < n; y++){
                    if(x == y){
                        continue;
                    }
                    if(map[x][y] > map[x][z] + map[z][y]){
                        map[x][y] = map[x][z] + map[z][y];
                    }
                }
            }
        }
        ArrayList<Integer> results = new ArrayList<Integer>();
        for(int z = 0; z < n; z++){
            for(int y = 0; y < n; y++){
                int leftTime = k - map[0][z]-map[z][y];
                if(leftTime >= 0){
                    ArrayList<Integer> result = recursive(y, leftTime, n);
                    for(Integer data : result){
                        if(!results.contains(data)){
                            results.add(data);
                        }
                    }
                }
            }
        }
        int [] answer;
        if(results.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[results.size()];
            Collections.sort(results);
            for(int i = 0; i < results.size(); i++){
                answer[i] = results.get(i);
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
