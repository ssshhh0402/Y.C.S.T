import java.util.Arrays;

public class 전화번호 {
    public static boolean solution(String [] Phone_book){
        boolean answer = true;
        Arrays.sort(Phone_book);
        for (int idx = 0; idx < Phone_book.length -1; idx++){
            if (Phone_book[idx+1].startsWith(Phone_book[idx])){
                return false;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new String [] {"119","97674223","1195524"}));
    }
}
