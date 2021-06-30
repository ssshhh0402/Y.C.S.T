package Midas;

import java.util.*;

public class Pro2_2 {
    public static int find(Set<Integer> items){
        int answer = Integer.MAX_VALUE;
        for(Integer item : items){
            answer = Math.min(item, answer);
        }
        return answer;

    }
    public static int solution(int n, int [] v1, int [] v2, int [] num, int [] amount) {
//        Map<Integer, ArrayList<Integer>> m = new LinkedHashMap<Integer, ArrayList<Integer>>();
        ArrayList<Set<Integer>> items = new ArrayList<Set<Integer>>();
        int [] teams = new int[n+1];
        for (int i = 0; i < v1.length; i++) {
            int one = v1[i], two = v2[i];
            boolean flag = false;
            for (Set<Integer> item : items) {
                if (item.contains(one)) {
                    flag = true;
                    item.add(two);
                    break;
                } else if (item.contains(two)) {
                    flag = true;
                    item.add(one);
                    break;
                }
            }
            if (!flag) {
                Set<Integer> temps = new LinkedHashSet<Integer>();
                temps.add(one);
                temps.add(two);
                items.add(temps);
            }
        }
        int [] header = new int[items.size()];
        int [] moneys = new int[items.size()];
        for(int i = 0; i < items.size(); i++){
            int min_s = find(items.get(i));
            header[i] = min_s;
        }
        for(int i = 0; i < items.size(); i++){
            Set<Integer> target = items.get(i);
            for(Integer item : target){
                teams[item] = i;
            }
        }
        for(int i = 0; i < num.length; i++){
            int student = num[i];
            int money = amount[i];
            int party = teams[student];
            moneys[party] += money;
        }
        int answer = 0;
        int answer_money = Integer.MIN_VALUE;
        for(int i = 0; i < moneys.length; i++){
            if(moneys[i] > answer_money){
                answer = header[i];
                answer_money = moneys[i];
            }else if(moneys[i] == answer_money){
                if(header[i] < answer){
                    answer = header[i];
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int n = 10;
        int [] v1 = new int [] {1, 10, 6, 5, 6, 9};
        int [] v2 = new int [] {3, 7, 2, 8, 7, 3};
        int [] num = new int [] {3, 4, 5, 1, 8, 7, 9, 2};
        int [] amount = new int [] {10, 5, 6, -6, -8, 2, -2, 5};
        System.out.println(solution(n, v1,v2,num, amount));
        n = 10;
        v1 = new int [] {8, 4, 4, 1	};
        v2 = new int [] {1, 10, 9, 4};
        num = new int [] {2, 5, 8, 6, 4, 1, 3, 10, 7, 4};
        amount = new int [] {3, -1, 3, 3, 1, -2, -4, 1, 2, -5};
        System.out.println(solution(n, v1, v2, num ,amount));
        n = 4;
        v1 = new int [] {1,3};
        v2 = new int [] {2,4};
        num = new int [] {2,2};
        amount = new int [] {1, -2};
        System.out.println(solution(n,v1,v2,num,amount));
        n = 6;
        v1 = new int [] {1, 5, 3, 6, 2};
        v2 = new int [] {5, 4, 6, 2, 3};
        num = new int [] {1, 5, 4, 3, 6, 2};
        amount = new int [] {3, 6, -2, 2, 2, 2};
        System.out.println(solution(n,v1,v2,num,amount));
    }
}
