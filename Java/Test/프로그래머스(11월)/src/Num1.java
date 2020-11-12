public class Num1 {
    public static int solution(int[] a, int[] b){
        int answer = 0;
        int n = a.length;
        for(int i = 0; i < n; i++){
            answer += (a[i] * b[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] {1,2,3,4}, new int[] {-3,-1,0,2}));
    }
}
