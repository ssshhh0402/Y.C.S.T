public class 조이스틱 {
    static String inputs;
    public static int find(int idx){
        char target = inputs.charAt(idx);
        int up = (int)'Z' - (int)target;
        int down = (int)target - 65;
        return Math.min(up, down);
    }
    public static int Left(int idx){
        int now = 0;
        if(idx == 0){
            now = inputs.length() - 1;
        }else{
            now = idx - 1;
        }
        while(now != idx){
            if(inputs.charAt(now) == 'Z'){
                now = now-1;
                if(now < 0){
                    now = inputs.length() - 1;
                }
            }else{
                return now;
            }
        }
        return now;
    }
    public static int Right(int idx){
        int now = 0;
        if(idx != inputs.length()-1){
            now = idx+1;
        }
        while(now != idx){
            if(inputs.charAt(now) == 'Z'){
                now = now+1;
                if(now == inputs.length()){
                    now = 0;
                }
            }else{
                return now;
            }
        }
        return now;
    }
    public static int solution(String name){
        int answer = 0;
        inputs = name;
        int now = 0;
        while(true){
            if(inputs.charAt(now) == 'Z'){
                now = now+1;
            }else{
                int count = find(now);
                answer += count;
                int left = Left(now);
                int right = Right(now);
                if(left == now){
                    break;
                }else if(left < right){
                    answer += left;
                    if(left + now > inputs.length()){
                        now = (left+ now) - inputs.length();
                    }else{
                        now = left + now;
                    }
                }else{
                    answer += right;
                    if(now - right < 0){
                        now = inputs.length() - 1 + (now - right);
                    }else{
                        now = now - right;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution("JEROEN"));
    }
}
