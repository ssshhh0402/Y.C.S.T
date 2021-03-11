
public class 브라이언의고민 {
    public static String solution(String sentence) {
        char target = ' ';
        String words = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char now = sentence.charAt(i);
            if (Character.isLowerCase(now)) {
                if (target == now) {
                    if (Character.isLowerCase(sentence.charAt(i + 1))) {
                        sb.append(words);
                        sb.append(" ");
                        target = ' ';
                    }
                } else {
                    if (target != ' ') {
                        sb.append(words);
                        sb.append(" ");
                        words = "";
                    }
                    target = now;
                }
            } else {
                words += now;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(solution("HaEaLaLaObWORLDb"));
        System.out.println(solution("SpIpGpOpNpGJqOqA"));
        System.out.println(solution("AxAxAxAoBoBoB"));
    }
}
