package KaKaoCommerce;
import java.util.LinkedHashMap;
import java.util.Map;
public class Pro1 {
    public static int solution(int [] gift_cards, int [] wants){
        int answer = 0;
        Map<Integer, Integer> base = new LinkedHashMap<Integer,Integer>();
        for(int want : wants){
            if(base.containsKey(want)){
                base.replace(want, base.get(want) + 1);
            }else{
                base.put(want, 1);
            }
        }
        for(int card : gift_cards){
            if(base.containsKey(card)){
                int item = base.get(card);
                if(item == 1){
                    base.remove(card);
                }else{
                    base.replace(card, item - 1);
                }
            }else{
                answer += 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int [] {4,5,3,2,1}, new int [] {2,4,4,5,1}));
        System.out.println(solution(new int [] {5,4,5,4,5}, new int [] {1,2,3,5,4}));
        System.out.println(solution(new int [] {1,2,3,4,5}, new int [] {3,5,2,4,1}));
        System.out.println(solution(new int [] {0,0,0,0,0}, new int [] {1,1,1,1,1}));
    }
}
