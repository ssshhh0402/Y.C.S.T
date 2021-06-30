package Midas;

import java.util.*;

public class Pro2 {
    static int [] teams;
    static int [] from;
    public static int find(int now){
        if(teams[now] == 0){
            return now;
        }else{
            int result = find(teams[now]);
            teams[now] = result;
            return result;
        }
    }
    public static void union(int now, int target){
        if(from[now] != 0) {
            teams[now] = target;
            int next = from[now];
            union(next, target);
        }

    }
    public static int getNum(int student_num){
        if(teams[student_num] == 0){
            return student_num;
        }else{
            return getNum(teams[student_num]);
        }
    }
    public static int solution(int n, int [] v1, int [] v2, int [] num, int [] amount){
        teams = new int[n+1];
        from = new int[n+1];
        Map<Integer, Integer> moneys = new LinkedHashMap<Integer, Integer>();
        for(int i = 1; i < v1.length+1; i++){
            int v_1 = v1[i-1], v_2 = v2[i-1];
            if(teams[v_1] == 0 && teams[v_2] == 0){
                if(v_1 > v_2){
                    teams[v_1] = v_2;
                    from[v_2] = v_1;
                    union(v_1, v_2);
                }else if(v_1 < v_2){
                    teams[v_2] = v_1;
                    from[v_1] = v_2;
                    union(v_2, v_1);
                }
            }else{
                if(teams[v_1] != 0){
                    int target = find(v_1);
                    if(target > v_2){
                        teams[v_1] = target;
                        teams[target] = v_2;
                    }else{
                        teams[v_1] = v_2;
                        teams[v_2] = target;
                    }
                    union(v_2, target);
                }else{
                    int target = find(v_2);
                    if(target > teams[v_1]){
                        teams[v_2] = target;
                    }else{
                        teams[v_1] = target;
                        teams[v_2] = v_1;
                    }
                    union(v_1, target);
                }
            }
        }
        int answer = 0;
        int answer_money = Integer.MIN_VALUE;
        for(int i = 1; i < teams.length; i++){
            if(!moneys.containsKey(teams[i]) && teams[i] == 0){
                moneys.put(i, 0);
            }
        }
        for(int i = 0; i < num.length; i++){
            int student_num = num[i];
            int money = amount[i];
            int get_student = getNum(student_num);
            moneys.replace(get_student, moneys.get(get_student)+ money);

        }
        for(int student : moneys.keySet()){
            if(moneys.get(student) > answer_money){
                answer_money = moneys.get(student);
                answer = student;
            }else if(moneys.get(student) == answer_money){
                answer = Math.min(answer, student);
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
