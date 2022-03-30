import java.util.ArrayList;

public class ExerCising {
    static ArrayList<String> al;
    public static boolean isPossible(String target){
        String As = "aaa", Bs = "bbb";
        if(!target.contains(As) && !target.contains(Bs)){
            return true;
        }else{
            return false;
        }
    }
    public static void recursive(int A, int B, String now){
        if(A == 0 && B == 0){
            al.add(now);
            return;
        }
        if(A != 0){
            recursive(A-1, B, now+"a");
        }
        if(B != 0){
            recursive(A, B-1, now+"b");
        }
    }
    public static String solution(int A, int B) {
        // write your code in Java SE 8
        al = new ArrayList<String>();
        if (A != 0){
            recursive(A-1, B, "a");
        }
        if(B != 0){
            recursive(A, B-1, "b");
        }
        String answer = "";
        for(String result : al){
            if(isPossible(result)){
                answer = result;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int A = 1;
        int B = 4;
        System.out.println(solution(A,B));
    }
}
