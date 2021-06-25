public class Lesson3_1 {
    public static int solution(int X, int Y ,int D){
        int target = Y - X;
        if(target % D == 0){
            return target / D;
        }else{
            return target / D + 1;
        }
    }
    public static void main(String[] args){
        System.out.println(solution(1,85,30));
    }
}
