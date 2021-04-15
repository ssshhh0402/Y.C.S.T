package Monthly;

import java.util.ArrayList;

public class Pro3 {
    static ArrayList<Integer>[] base;
    static int answer = Integer.MAX_VALUE;
    public static void find(int [] a, int count, int zeros){
        if(zeros == a.length){
            answer = Math.min(count, answer);
            return;
        }
        for(int i = 0 ; i < a.length; i++){
            for(int j : base[i]){
                if(a[i] != 0 && a[j] != 0){
                    int n = a[i];
                    a[j] += a[i];
                    a[i] = 0;
                    if(a[j] == 0){
                        find(a, count + Math.abs(n), zeros+2);
                    }else{
                        find(a, count + Math.abs(n), zeros+1);
                    }
                    a[j] -= n;
                    a[i] += n;
                }
            }
        }

    }
    public static int solution(int [] a, int[][] edges){
        int n = a.length;
        int counts = 0;
        for(int item : a){
            if(item == 0){
                counts += 1;
            }
        }
        base = new ArrayList[n];
        for(int i = 0 ; i < n; i++){
            base[i] = new ArrayList<Integer>();
        }
        for(int [] edge : edges){
            base[edge[0]].add(edge[1]);
            base[edge[1]].add(edge[0]);
        }
        for(int i = 0; i < n; i++){
            for(int j : base[i]){
                if(a[i] != 0 && a[j] != 0) {
                    int temps = a[i];
                    a[j] += temps;
                    a[i] = 0;
                    if(a[j] == 0){
                        find(a, Math.abs(temps), counts+2);
                    }else{
                        find(a, Math.abs(temps), counts+1);
                    }
                    a[j] -= temps;
                    a[i] = temps;

                    counts -= 1;
                }
            }
        }
        if(answer == Integer.MAX_VALUE){
            return -1;
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        System.out.println(solution(new int [] {-5,0,2,1,2}, new int [][] {{0,1},{3,4},{2,3},{0,3}}));
    }
}
