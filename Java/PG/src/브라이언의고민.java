import java.util.ArrayList;

public class 브라이언의고민 {
    static String base;
    public static String find(Character target, int idx){
        String words = "";
        boolean flag = false;
        for(int i = idx+1; idx < base.length(); idx++){
            char now = base.charAt(i);
            if(Character.isLowerCase(now)){
                if(now == target){
                    continue;
                }else{
                    words += find(now, i);
                }
            }else{
                words += now;
            }
        }
    }
    public static String solution(String sentence){
        ArrayList<String> answer = new ArrayList<String>();
        char target = ' ';
        String words = "";
        base = sentence;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < sentence.length(); i++){
            char now = sentence.charAt(i);
            if(Character.isLowerCase(now)){
                String word = find(now, i);
                if(word.length() != 0){
                    words += find(now, i);
                    sb.append(words + " ");
                }else{
                    return "Invalid";
                }
                words += find(now, i);
                sb.append(words + " ");
            }else{
                words += now;
            }
        }
    }
    public static void main(String[] args){
        System.out.println(solution("HaEaLaLaObWORLDb"));
        System.out.println(solution("SpIpGpOpNpGJqOqA"));
        System.out.println(solution("AxAxAxAoBoBoB"));
    }
}
