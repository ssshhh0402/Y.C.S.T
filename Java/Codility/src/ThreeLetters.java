import java.util.ArrayList;

public class ThreeLetters {


    public static String solution(int A, int B){
        String answer = "";
        int count;
        while(A != 0 || B != 0){
            if(A > B){
                count = Math.min(2, A);
                for(int i = 0; i < count; i++){
                    answer += 'a';
                }
                A -= count;
                count = Math.min(2, B);
                for(int i = 0; i < count; i++){
                    answer += 'b';
                }
                B -= count;
            }else{
                count = Math.min(2, B);
                for(int i = 0; i < count; i++){
                    answer += 'b';
                }
                B -= count;
                count = Math.min(2, A);
                for(int i = 0; i < count; i++){
                    answer += 'a';
                }
                A -= count;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int A = 8, B = 4;
        System.out.println(solution(A,B));
    }
}
