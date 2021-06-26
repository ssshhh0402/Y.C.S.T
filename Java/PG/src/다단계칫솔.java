import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 다단계칫솔 {
    static Map<String, Integer> m;
    static Map<String, String> to;
    static class Item{
        int money;
        String name;

        Item(String a, int b){
            this.name = a;
            this.money = b;
        }
    }
    public static void find(String name, int amount){
        Queue<Item> q = new LinkedList<Item>();
        q.add(new Item(name, 100 * amount));
        while(!q.isEmpty()){
            Item now = q.poll();
            m.replace(now.name, m.get(now.name) + (now.money / 10) * 9);
            if(!to.get(now.name).equals("-")){
                q.add(new Item(to.get(now.name), now.money / 10));
            }
        }
    }
    public static int [] solution(String [] enroll, String [] referral,String [] seller, int[] amount){
        m = new LinkedHashMap<String, Integer>();
        to = new LinkedHashMap<String, String>();
        int [] answers = new int[enroll.length];
        for(int i = 0 ; i < enroll.length; i++){
            m.put(enroll[i], 0);
            to.put(enroll[i],referral[i]);
        }
        for(int i = 0; i < seller.length; i++){
            find(seller[i], amount[i]);
        }
        for(int i = 0 ; i < enroll.length; i++){
            answers[i] = m.get(enroll[i]);
        }
        return answers;
    }
    public static void main(String[] args) throws IOException {
        int [] answers = solution(new String [] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},new String [] {"young", "john", "tod", "emily", "mary"},new int [] {12, 4, 2, 5, 10});
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
