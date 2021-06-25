import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Lesson4_2 {
    public static int [] solution(int N, int [] A){
        int[] answers = new int[N];
        for(int a : A){
            if(a  == (N+1)){
                int [] temps = Arrays.copyOf(answers, N);
                Arrays.sort(temps);
                Arrays.fill(answers, temps[N-1]);
            }else{
                answers[a-1] += 1;
            }
        }
        return answers;
    }
    public static void main(String[] args){
        int [] answers = solution(5,new int [] {3,4,4,6,1,4,4});
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
