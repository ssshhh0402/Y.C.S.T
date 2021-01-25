import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pro5 {

    public static int getMinimumNums(List<Integer> arr){
        int n = arr.size();
        int answer = 0;
        for(int i = 1; i < n; i++){
            if(arr.get(i) < arr.get(i-1)){
                answer += 1;
            }
        }
        return answer;
    }
    public static void main(String[] argh){
        int [] base = {5,1,3,2};
        List<Integer> toGo = new LinkedList<Integer>();
        for(int item: base){
            toGo.add(item);
        }
        System.out.println(getMinimumNums(toGo));
    }
}
