import java.io.IOException;

public class 풍선터뜨리기 {
    public static int solution(int [] a){
        if(a.length == 1){
            return 1;
        }
        int answer= 2;
        int min = Integer.MAX_VALUE;
        int n = a.length;
        int [] left = new int [n];
        int [] right = new int [n];
        for(int i = 0 ; i < n; i++){
            if(min > a[i]){
                min = a[i];
            }
            left[i] = min;
        }
        min = Integer.MAX_VALUE;
        for(int i = n-1; i >= 0; i--){
            if(min > a[i]){
                min = a[i];
            }
            right[i] = min;
        }
        for(int i = 1; i < n; i++){
            if(a[i] > left[i] && a[i] < right[i]){
                continue;
            }
            answer += 1;
        }
        return answer;

    }
    public static void main(String[] args) throws IOException{
        System.out.println(solution(new int [] {1,2,3}));
    }
}
