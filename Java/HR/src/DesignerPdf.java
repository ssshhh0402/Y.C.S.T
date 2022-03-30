import java.util.ArrayList;
import java.util.List;

public class DesignerPdf {
    public static int solution(List<Integer> h, String word){
        int answer = Integer.MIN_VALUE;
        int n = word.length();
        for(int i = 0 ; i < n; i++){
            char now = word.charAt(i);
            answer = Math.max(answer, h.get(now-'0'-49));
        }
        return answer * n;
    }
    public static void main(String[] args){
        String word = "abc";
        int [] H = new int [] {1, 3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        List<Integer> h = new ArrayList<Integer>();
        for(int hh : H){
            h.add(hh);
        }
        System.out.println(solution(h, word));
    }
}
