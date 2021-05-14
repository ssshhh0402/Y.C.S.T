package Monthly5;

import java.io.IOException;

public class Pro1 {
    public static boolean isPos(int target){
        int count= 0;
        for(int i = 1; i < target+1; i++){
            if(target % i == 0){
                count += 1;
            }
        }
        return (count % 2 == 0);
    }
    public static int solution(int left, int right){
        int answer = 0 ;
        for(int i = left; i <= right; i++){
            if(isPos(i)){
                answer += i;
            }else{
                answer -= i;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        System.out.println(solution(13, 17));
    }
}
