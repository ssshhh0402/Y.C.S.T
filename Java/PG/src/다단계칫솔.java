import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class 다단계칫솔 {

    public static int [] solution(String [] enroll, String [] referral,String [] seller, int[] amount){
        Map<String, Integer> index = new LinkedHashMap<String, Integer>();
        Map<String, String> to = new LinkedHashMap<String, String>();
        int [] answer = new int[enroll.length];
        for(int i = 0 ; i < enroll.length; i++){
            index.put(enroll[i], i);
            to.put(enroll[i],referral[i]);
        }
        for(int i = 0; i < seller.length; i++){
            String name = seller[i];
            int money = 100 * amount[i];
            while(!name.equals("-")){
                int profit = money - (money / 10);
                answer[index.get(name)] += profit;
                money /= 10;
                name = to.get(name);
                if(money == 0){
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        int [] answers = solution(new String [] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},new String [] {"young", "john", "tod", "emily", "mary"},new int [] {12, 4, 2, 5, 10});
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
