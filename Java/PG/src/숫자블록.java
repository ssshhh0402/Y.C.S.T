public class 숫자블록 {
    public static int[] solution(long start, long end){
        int [] answer = {};
        int s = (int)start, e = (int) end;
        int n = e - s + 1;
        int [] base = new int[e+1];
        for(int i = s; i < e+1; i++){
            for(int j = 2 * i; j < e+1; j += i){
                base[j] = i;
            }
        }
        answer = new int[n];
        for(int i = 0 ; i < n; i++){
            answer[i] = base[s+i];
        }
        return answer;
    }
    public static void main(String[] args){
        int [] temps = solution(1, 10);
        for( int item : temps){
            System.out.println(item);
        }
    }
}
