import java.util.LinkedList;
import java.util.List;

public class Pro2 {
    public static int maxDifference(int[] px){
        int count = px[0];
        int answer = 0;
        for(int i = 1; i < px.length; i++){
            if(px[i] < count){
                count = px[i];
            }else if(px[i] > count){
                int diff = px[i] - count;
                answer = Math.max(diff, answer);
            }
        }
        return answer;
    }
    public static void main(String[] argh){
        int[] inputs = new int [] {7,1,2,5};
        System.out.println(maxDifference(inputs));
    }
}
