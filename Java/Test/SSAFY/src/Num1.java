import java.util.ArrayList;
import java.util.List;

public class Num1 {
    static int findLeft(int a, List<Integer> arr){
        int answer = 0;
        for (int idx = 0; idx < a; idx++){
            answer += arr.get(idx);
        }
        return answer;
    }
    static int findRight(int a, List<Integer> arr){
        int answer = 0;
        for (int idx = a+1; idx < arr.size(); idx++){
            answer += arr.get(idx);
        }
        return answer;
    }
    public static int balanced(List<Integer> arr){
        int N = arr.size();
        int answer = 0;
        for (int idx = 1; idx < N-1; idx++){
            int left = findLeft(idx, arr);
            int right = findRight(idx, arr);
            if (left == right){
                answer = idx;
                break;
            }
        }
        return answer;
    }
    public static void main(String [] args){
        List <Integer> temps = new ArrayList<>();
//        temps.add(1);
//        temps.add(2);
//        temps.add(1);
//        System.out.println(balanced(temps));
        temps.clear();
        temps.add(1);
        temps.add(2);
        temps.add(3);
        temps.add(3);
        System.out.println(balanced(temps));
    }
}
