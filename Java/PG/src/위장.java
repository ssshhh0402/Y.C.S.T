import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public static int solution(String [][] clothes){
        int answer = 1;
        Map<String, ArrayList<String>> base = new HashMap<>();
        for(String[] clothe : clothes){
            if(!base.containsKey(clothe[1])){
                ArrayList<String> temps = new ArrayList<String>();
                temps.add(clothe[0]);
                base.put(clothe[1],temps);
            }else{
                ArrayList<String> now = base.get(clothe[1]);
                now.add(clothe[0]);
                base.replace(clothe[1], now);
            }
        }
        for(String kind : base.keySet()){
            answer *= (base.get(kind).size() - 1);
        }
        return answer - 1;
    }
    public static void main(String[] args) {
        System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }
}
