
public class Lesson4_2 {
    public static int [] solution(int N, int [] A){
        int[] answers = new int[N];
        int max = 0, temps = 0;
        for(int a : A){
            if (a == N+1){
                max = temps;
            }else{
                answers[a-1] = Math.max(answers[a-1]+1, max + 1);
                temps = Math.max(answers[a-1],temps);
            }
        }
        for(int i = 0 ; i < N; i++){
            if(answers[i] < max){
                answers[i] = max;
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
