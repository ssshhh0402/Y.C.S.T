package LV3;

import java.util.LinkedHashMap;
import java.util.Map;

public class 다단계칫솔 {
    static class Person{
        int idx, money;
        String upper;


        Person(int a, int b, String c){
            this.idx = a;
            this.money = b;
            this.upper = c;
        }
    }
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Person> m = new LinkedHashMap<String, Person>();
        for(int i = 0 ; i < enroll.length; i++){
            m.put(referral[i], new Person(i, 0,enroll[i]));
        }
        for(int i = 0 ; i < seller.length; i++){
            String now = seller[i];
            int money = amount[i] * 100;
            while(!now.equals("-")){
                Person p = m.get(now);
                int temps = money - (money / 10);
                m.replace(now, new Person(p.idx, p.money+temps,p.upper));
                now = p.upper;
                money -= temps;
            }
        }
        for(String key : m.keySet()){
            Person p = m.get(key);
            answer[p.idx] = p.money;
        }
        return answer;
    }
    public static void main(String[] args){
        String [] enroll = new String [] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String [] referral = new String [] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String [] seller = new String [] {"young", "john", "tod", "emily", "mary"};
        int [] amount = new int [] {12, 4, 2, 5, 10};
        int [] answers = solution(enroll, referral, seller, amount);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
