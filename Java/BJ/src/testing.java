import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class testing {
    public static int solution(int [] A){
        int answer = 0;
        Set<Integer> items = new HashSet<Integer>();
        for(int item : A){
            if(item >= 0) {
                items.add(item);
            }
        }
        for(int i = 1; i < 1000001; i++){
            if(!items.contains(i)){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        System.out.println(solution(new int [] {1,3,6,4,1,2}));
    }
}
