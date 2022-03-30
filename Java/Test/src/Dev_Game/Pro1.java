package Dev_Game;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Pro1 {
    public static class Item{
        long start, end, money;

        Item(long a, long b, long c){
            this.start = a;
            this.end = b;
            this.money = c;
        }
    }
    public static Map<Integer, Integer> getMonths(){
        Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
        for(int i = 1; i < 8; i++){
            if(i == 2){
                result.put(i, 28);
            }else{
                if(i % 2 == 0){
                    result.put(i, 30);
                }else{
                    result.put(i, 31);
                }
            }
        }
        for(int i = 8; i < 13; i++){
            if(i % 2 == 0){
                result.put(i,31);
            }else{
                result.put(i, 30);
            }
        }
        return result;
    }
    public static long getDate(String data){
        Map<Integer, Integer> months = getMonths();
        String [] datas = data.split("/");
        long dates = 0;
        int month = Integer.parseInt(datas[1]), day = Integer.parseInt(datas[2]);
        for(int i = 1 ; i <month; i++){
            dates += months.get(month);
        }
        return dates + day;
    }
    public static int getGrade(long money){
        int grade;
        if(0 <= money && money < 10000){
            grade = 0;
        }else if(money >= 10000 && money < 20000){
            grade = 1;
        }else if(money >= 20000 && money < 30000){
            grade = 2;
        }else if(money >= 30000 && money < 40000){
            grade = 3;
        }else{
            grade = 4;
        }
        return grade;
    }
    public static int [] solution(String [] purchase){
        int [] answer = new int[5];
        int grade;
        long endDate = getDate("2019/12/31");
        long start = 0, end = 0, money = 0, beforeMoney= 0;
        for(int i = 0 ; i < purchase.length; i++){
            String [] datas = purchase[i].split(" ");
            long nowStart = getDate(datas[0]);
            long nowEnd = nowStart + 30;
            long nowMoney = Long.parseLong(datas[1]);
            if(i == 0){
                answer[0] += nowStart-1;
                money += nowMoney;
                start= nowStart;
                end = nowEnd;
                beforeMoney = nowMoney;
            }else {
                if (nowStart < end) {
                    grade = getGrade(money);
                    answer[grade] += (nowStart - start);
                    money += nowMoney;
                    grade = getGrade(money);
                    answer[grade] += (end - nowStart);
                    money -= beforeMoney;
                    start = nowStart;
                    end = nowEnd;
                    beforeMoney = nowMoney;
                } else {
                    grade = getGrade(money);
                    answer[grade] += (end - start);
                    money -= beforeMoney;
                    answer[grade] += (nowStart - end);
                    start = nowStart;
                    end = nowEnd;
                    beforeMoney = nowMoney;
                }
            }
        }
        grade = getGrade(money);
        answer[grade] += (end-start);
        money -= beforeMoney;
        grade = getGrade(money);
        answer[grade] += (endDate - end);
        return answer;
    }
    public static void main(String[] args){
        String [] purchase = new String [] {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};
        int [] answers = solution(purchase);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
