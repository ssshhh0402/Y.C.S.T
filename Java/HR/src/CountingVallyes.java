public class CountingVallyes {
    public static int countingValleys(int steps, String path){
        int answer = 0;
        int now = 0;
        boolean flag = false;
        for(int i = 0; i < steps; i++){
            if(now == 0 && flag){
                flag = false;
                answer += 1;
            }
            if(path.charAt(i) == 'U'){
                if(now < 0 && path.charAt(i-1) == 'D'){
                    flag = true;
                }
                now += 1;
            }else{
                now -= 1;
            }
        }
        if(now == 0 && flag){
            answer += 1;
        }
        return answer;
    }
    public static void main(String[] args){
        int steps = 10;
        String path = "DUDDDUUDUU";
        System.out.println(countingValleys(steps, path));
    }
}
