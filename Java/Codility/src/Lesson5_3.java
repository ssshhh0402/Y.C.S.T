public class Lesson5_3 {
    public static int solution(int [] A){
        float minAvg = (A[0] + A[1]) / 2f;
        int minIndex = 0;
        for (int i = 2; i < A.length; i++) {
            float avg = (A[i - 2] + A[i - 1] + A[i]) / 3f;
            if (minAvg > avg) {
                minAvg = avg;
                minIndex = i - 2;
            }

            avg = (A[i - 1] + A[i]) / 2f;
            if (minAvg > avg) {
                minAvg = avg;
                minIndex = i - 1;
            }
        }
        return minIndex;
    }
    public static void main(String[] args){
        int [] A  = new int [] {4,2,2,5,1,5,8};
        System.out.println(solution(A));
        A = new int [] {10000, -10000};
        System.out.println(solution(A));
    }
}
