package Interndev;

import java.util.ArrayList;
import java.util.Collections;

public class Pro1{
    public static class Item implements Comparable<Item>{
        int money, time;

        Item(int a, int b){
            this.money = a;
            this.time = b;
        }
        public int compareTo(Item i){
            return this.time - i.time;
        }
    }
    public static int [] solution (String code, String day, String[] data){
        int [] answer = {};
        ArrayList<Item> base = new ArrayList<Item>();
        for(String item : data){
            String [] info = item.split(" ");
            info[0] = info[0].substring(6, info[0].length());
            info[1] = info[1].substring(5, info[1].length());
            info[2] = info[2].substring(5, info[2].length());
            if(info[1].equals(code) && info[2].startsWith(day)){
                int money = Integer.parseInt(info[0]);
                int time = Integer.parseInt(info[2].substring(7, info[2].length()));
                base.add(new Item(money, time));
            }
        }
        Collections.sort(base);
        answer = new int[base.size()];
        for(int i = 0 ;i < base.size(); i++){
            answer[i] = base.get(i).money;
        }
        return answer;
    }
    public static void main(String[] args){
        int [] answers = solution("012345","20190620",new String []{"price=80 code=987654 time=2019062113","price=90 code=012345 time=2019062014","price=120 code=987654 time=2019062010","price=110 code=012345 time=2019062009","price=95 code=012345 time=2019062111"});
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
