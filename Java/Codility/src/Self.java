public class Self {
    public static int getTime(String T){
        String [] times = T.split(":");
        int time = 0;
        time += 60 * Integer.parseInt(times[0]);
        time += Integer.parseInt(times[1]);
        return time;
    }
    public static int solution(String E, String L){
        int times = getTime(L) - getTime(E);
        int answer = 2;
        if(times <= 60){
            answer += 3;
        }else{
            answer += 3;
            times -= 60;
            if(times % 60 == 0){
                answer += 4 * (times / 60);
            }else{
                int temps = times / 60;
                answer += 4 * ((times / 60) + 1);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String E = "10:00", L = "13:21";
        System.out.println(solution(E, L));
    }
}
