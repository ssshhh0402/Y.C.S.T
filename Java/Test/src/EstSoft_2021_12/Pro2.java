package EstSoft_2021_12;

import java.util.ArrayList;

public class Pro2 {
    static ArrayList<ArrayList<Integer> > comb;
    static int n;
//    public static void find(int idx, int items, int counts, int r){
//        if(counts == r){
//            answer = Math.max(answer, items);
//            return;
//        }
//
//        for(int i = idx+1; i < n; i++){
//            int temps = 0;
//            for(int j : al[i]){
//                count[j] -= 1;
//                if(count[j] == 0){
//                    temps += 1;
//                }
//            }
//            find(i,items + temps, i+1, r);
//        }
//    }
    public static void makeCombi(ArrayList<Integer> route, int depth, int idx){
        if(route.size() == depth){
            comb.add((ArrayList)(route.clone()));
            return;
        }
        for(int i = idx; i < n; i++){
            route.add(i);
            makeCombi(route, depth, i+1);
            route.remove(route.size()-1);
        }
    }
    public static void initComb(int r){
        comb = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> route = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            route.add(i);
            makeCombi(route, r, i+1);
            route.remove(route.size()-1);
        }
    }
    public static int solution(int [][] needs, int r){
        int answer = 0;
        n = needs[0].length;
        ArrayList<Integer>[] al = new ArrayList[n+1];
        int [] base = new int[needs.length];
        for(int i = 0; i < n; i++){
            al[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < needs.length; i++){
            for(int j = 0; j < n; j++){
                if(needs[i][j] == 1){
                    base[i] += 1;
                    al[j].add(i);
                }
            }
        }
        initComb(r);
        for(ArrayList<Integer> combination : comb){
            int [] count = new int[needs.length];
            for(int i = 0; i < needs.length; i++){
                count[i] = base[i];
            }
            int counter = 0;
            for(Integer target : combination){
                for(int i : al[target]){
                    count[i] -= 1;
                    if(count[i] == 0){
                        counter += 1;
                    }
                }
            }
            answer = Math.max(answer, counter);
        }
//        for(int i = 0; i < n; i++){
//            int temps = 0;
//            count = new int[needs.length];
//            for(int j = 0; j < needs.length; j++){
//                count[j] = base[j];
//            }
//            for(int j : al[i]){
//                count[j] -= 1;
//                if(count[j] == 0){
//                    temps += 1;
//                }
//            }
//            find(i, temps, 1, r); // idx, 만들어진 개수, count, maxDepth;
//        }
        return answer;
    }
    public static void main(String[] args){
        int [][] needs = new int [][] {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
        int r = 2;
        needs = new int [][] {{1,0,0}, {0,1,0}, {0,0,1}};
        System.out.println(solution(needs, r));
    }
}
