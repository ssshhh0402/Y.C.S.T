public class 문자열압축 {
    public static int find(String s, int target){
        String temps = s.substring(0, target);
        int count = 1;
        String answer = "";
        for(int idx= target; idx < s.length(); idx += target){
            String now;
            if (idx + target >= s.length()){
                now = s.substring(idx, s.length());
            }else{
                now = s.substring(idx, idx+target);
            }
            if (now.equals(temps)){
                count += 1;
            }else{
                String temp;
                if (count > 1){
                    temp = String.valueOf(count) + temps;
                }else{
                    temp = temps;
                }
                answer += temp;
                count = 1;
                temps = now;
            }
        }
        if (count > 1){
            String temp = String.valueOf(count) + temps;
            answer+=(temp);
        }else{
            String temp = temps;
            answer += temp;
        }
        return answer.length();
    }
    public static int solution(String s){
        int answer = 0;
        if (s.length() == 1){
            return 1;
        }else{
            int N = s.length();
            for(int idx = 1; idx < (N / 2) + 1; idx++){
                int temps = find(s, idx);
                if (answer == 0){
                    answer = temps;
                }else{
                    answer = Math.min(answer, temps);
                }
            }
        }
        return answer;
    }
    public static void main(String [] args){
        int answer = solution("aabbaccc");
        int answer2 = solution("ababcdcdababcdcd");
        int answer3 = solution("abcabcdede");
        System.out.println(answer);
        System.out.println(answer2);
        System.out.println(answer3);
    }
}
