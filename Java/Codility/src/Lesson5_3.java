public class Lesson5_3 {
    public static int solution(int [] A){
//        int [] sums = new int[A.length];
//        sums[0] = A[0];
//        for(int i = 1; i < A.length;i++){
//            sums[i] += sums[i-1] + A[i];
//        }
        int left = 0, right = 0, temps = 0, now = 0, comp = Integer.MAX_VALUE;
        while(left <= right){
            temps = now / (right - left + 1);
            if(right == A.length - 1){
                break;
            }else if(temps < comp){
                now += A[right ++];
            }else{
                now -= A[left ++];
            }
            if(temps < comp){
                comp = now;
            }
        }
        return left;
    }
    public static void main(String[] args){
        int [] A  = new int [] {4,2,2,5,1,5,8};
        System.out.println(solution(A));
        A = new int [] {10000, -10000};
        System.out.println(solution(A));
    }
}
