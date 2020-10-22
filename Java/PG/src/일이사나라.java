public class 일이사나라 {
    public static String solution(int n){
        StringBuilder sb = new StringBuilder();
        String [] numbers = {"4","1","2"};
        String answer = "";
        int a, b;
        while(n > 0){
            a = n / 3;
            b = n % 3;
            if ( b == 0){
                n = a - 1;
            }else{
                n = a;
            }
            sb.append(numbers[b]);
        }
        return sb.toString();
    }
    public static void main(String [] args){
        String answer;
        answer = solution(11);
        System.out.println(answer);
        answer = solution(13);
        System.out.println(answer);
        answer = solution(513);
        System.out.println(answer);

    }
}
