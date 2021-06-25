import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson1 {
    public static int solution(int N){
        int answer = 0;
        int count = 0;
        boolean flag = false;
        int a = 0;
        while(N != 0){
            a = N % 2;
            N /= 2;
            if(a == 1){
                if(!flag){
                    flag = true;
                }else{

                    answer = Math.max(answer, count);
                    count = 0;
                }
            }
            else{
                if(flag){
                    count += 1;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
    }
}
