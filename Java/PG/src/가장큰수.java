import java.util.*;
public class 가장큰수 {
    public static String solution(int[] numbers){
        String answer = "";
        int N = numbers.length;
        String [] newOne = new String[N];
        for(int i = 0 ; i < N; i++){
            newOne[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(newOne, new Comparator<String>(){
            @Override
            public int compare(String n1, String n2){
                // 더해서 큰 값 만드는 내림 차순
                return (n2+n1).compareTo(n1+n2);
            }
        });
        for(int i = 0 ; i < N; i++){
            answer += newOne[i];
        }
        if(answer.startsWith("0")){
            answer = "0";
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[] {6,10,2}));
        System.out.println(solution(new int [] {0,0,0,0}));
    }
}
