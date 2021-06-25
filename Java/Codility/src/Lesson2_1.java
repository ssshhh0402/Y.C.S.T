import java.util.Deque;
import java.util.LinkedList;

public class Lesson2_1 {
    public static int [] rotate(int [] A){
        int target = A[0];
        int temps = 0;
        A[0] = A[A.length-1];
        for(int i = 1; i < A.length; i++){
            temps = A[i];
            A[i] = target;
            target = temps;
        }
        return A;
    }
    public static int[] solution(int [] A, int K){
        for(int i = 0; i < K; i++){
            A = rotate(A);
        }
        return A;
    }
    public static void main(String[] args){
        int [] answers = solution(new int [] {3,8,9,7,6}, 3);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
