package Trenbe;

import java.util.Arrays;
import java.util.Comparator;

public class Pro1 {
    public static int solution(int N){
        String [] Ns =String.valueOf(N).split("");
        int answer = 0;
        for(int i = 0; i < 2; i++){
            if(i == 0){
                Arrays.sort(Ns);
                answer += Integer.parseInt(String.join("", Ns));
            }else{
                Arrays.sort(Ns, Comparator.reverseOrder());
                answer += Integer.parseInt(String.join("",Ns));
            }
        }
        return answer;


    }
    public static void main(String[] args){
        int N = 2613;
        System.out.println(solution(N));
        N = 33285;
        System.out.println(solution(N));

    }
}
