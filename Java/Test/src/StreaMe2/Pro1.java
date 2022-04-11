package StreaMe2;

public class Pro1 {
    public static int solution(int A, int B){
        int start = 1, end = Math.max(A,B)-1;
        int answer = 0;
        int mid = 0;
        int count;
        while(start <= end){
            mid = (start+end) / 2;
            count = (A / mid + B / mid);
            if(count >= 4){
                answer = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int A = 10, B= 21;
        System.out.println(solution(A,B));  //7
        A = 13;
        B = 11;
        System.out.println(solution(A,B)); //5
        A = 2;
        B = 1;
        System.out.println(solution(A, B)); //0
        A = 1;
        B = 8;
        System.out.println(solution(A,B)); //2
    }
}
