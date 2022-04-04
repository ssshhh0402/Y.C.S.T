import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class 약{
    public static long getSum(int target){
        long sum = 0;
        for(int i = 1; i <= Math.sqrt(target); i++){
            if(target % i == 0){
                sum += i;
                sum += target / i;
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        for( int i=1; i<=n; i++ ) {
            answer += ( n/i ) * i;
        }
        System.out.println(answer);
    }
}