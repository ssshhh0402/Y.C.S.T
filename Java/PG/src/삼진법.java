public class 삼진법 {
    public static int solution(int n){
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n / 3 != 0){
            int now = n % 3;
            sb.append(now);
            n = n / 3;
        }
        sb.append(n);
        String[] now = sb.toString().split("");
        int m = now.length;
        for(int i = 0; i < m; i++){
            int temps = Integer.parseInt(now[m - i - 1]);
            answer += (Math.pow(3,i) * temps);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(45));
    }
}
