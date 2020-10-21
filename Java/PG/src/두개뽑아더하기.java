import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 두개뽑아더하기 {
    public int[] main(int[] numbers){
        List<Integer>  temps = new ArrayList<>() ;
        for(int idx = 0; idx < numbers.length; idx++) {
            for(int idx2 = idx+1; idx2 < numbers.length; idx2++){
                int temp = (numbers[idx] + numbers[idx2]);
                if (!temps.contains(temp)){
                    temps.add(temp);
                }
            }
        }
        int [] answer = new int[temps.size()];
        for(int a=0; a < temps.size(); a++){
            answer[a] = temps.get(a);
        }
        Arrays.sort(answer);
        return answer;
    }

    }