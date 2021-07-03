
public class Lesson4_4 {
    public static int solution(int[] A){
        int answer = 1;
        int N = A.length;
        boolean [] answers = new boolean [A.length+1];
        for(int a : A){
            if(a > N || answers[a]){
                answer = 0;
                break;
            }else{
                answers[a] = true;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] answers = new int[] {4,1,3,2};
        System.out.println(solution(answers));
        answers = new int [] {4,1,3};
        System.out.println(solution(answers));
    }
}
