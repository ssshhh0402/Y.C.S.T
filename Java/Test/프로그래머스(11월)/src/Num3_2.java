import java.util.ArrayList;
import java.util.List;

public class Num3_2 {
    public static int count(int idx, List<Integer> b, int count){
        if (b.size() % 2 == 0){

        }

        for (int i = idx+1; )
    }
    public static int solution(int[] a){
        if(a.length == 1){
            return -1;
        }
        int answer = 0;
        List<Integer> b = new ArrayList<Integer>();
        for(int idx = 0; idx < a.length; idx++){
            b.add(a[idx]);
            int count = find(idx,b,1);
            b.remove(0);
        }
    }
}
