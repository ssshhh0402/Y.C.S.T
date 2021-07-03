public class Lesson4_3 {
    public static int solution(int [] A){
        boolean [] answers = new boolean[1000001];
        int answer = 0;
        for(int a : A){
            if(a > 0){
                answers[a] = true;
            }
        }
        for(int i =  1; i < 1000001; i++){
            if(!answers[i]){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int [] a = new int [] {1,3,6,4,1,2};
        System.out.println(solution(a));
        a = new int [] {-1,-3};
        System.out.println(solution(a));
        a = new int [] {1,2,3};
        System.out.println(solution(a));
    }
}
