public class Num2 {
    public static String find(int target){
        String answer = "";
        while(target != 0){
            int s = target % 2;
            answer = String.valueOf(s) + answer;
            target = target / 2;
        }
        return answer;
    }
    public static int[] solution(String s){
        int count = 0;
        int T = 0;
        char [] se;
        String x = "";
        while (true) {
            T += 1;
            se = s.toCharArray();
            for (char se2 : se) {
                if (se2 == '0') {
                    count += 1;
                } else {
                    x += se2;
                }
            }
            int c = x.length();
            s = find(c);
            x = "";
            if (s.equals("1")){
                break;
            }
        }
        int [] answer = new int [] {count, T};
        return answer;
    }

    public static void main(String [] args){
        System.out.println(solution("110010101001"));
    }
}
