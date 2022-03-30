package LV3;
import java.util.*;
public class 다단계칫솔2 {
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];
        Map<String, Integer> people = new LinkedHashMap<String, Integer>();
        for(int i = 0; i< n; i++){
            people.put(enroll[i], i);
        }
        int [] upper = new int[n];
        for(int i = 0; i < n; i++){
            if(!referral[i].equals("-")){
                upper[i] = people.get(referral[i]);
            }else{
                upper[i] = -1;
            }
        }
        for(int i = 0; i < seller.length; i++){
            int sell = people.get(seller[i]);
            int money = amount[i] * 100;
            Queue<int[]> q = new LinkedList<int[]>();
            q.add(new int[]{sell, money});
            while(true){
                int [] now = q.poll();
                int up = upper[now[0]];
                int giveMoney = now[1] / 10;
                if(giveMoney < 1){
                    answer[now[0]] += now[1];
                    break;
                }else {
                    answer[now[0]] += now[1] - giveMoney;
                    if(up != -1) {
                        q.add(new int[]{up, now[1] / 10});
                    }else{
                        break;
                    }
                }
            }
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
