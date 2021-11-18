import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyTesting {
    public static int solution(int a, int b){
        int A = (int)Math.sqrt(a);
        int B = (int)Math.sqrt(b);
        int C = B-A;
        if(Math.sqrt(a) % 1 == 0){
            C += 1;
        }
        return C;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T -- >= 0){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            System.out.println(solution(a,b));
        }


    }
}
