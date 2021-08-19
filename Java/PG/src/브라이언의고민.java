import java.util.LinkedList;
import java.util.Queue;

public class 브라이언의고민 {
    public static String solution(String sentence) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<Character>();
        for(int i = 0 ; i < sentence.length(); i++){
            char now = sentence.charAt(i);
            if(Character.isUpperCase(now)){
                q.add(now);
            }else{
                if(sentence.charAt(i+2) == now){
                    int j = i+2;
                    while(j < sentence.length()){
                        q.add(sentence.charAt(j-1));
                        if(sentence.charAt(j+2) == now){
                            j += 2;
                        }else{
                            i = j;
                        }
                    }
                }else{
                    for(int j = i; j < sentence.length(); j++){
                        char target = sentence.charAt(j);
                        if(Character.isLowerCase(target)){
                            if(target == now){
                                i = j;
                                break;
                            }else{
                                return "invalid";
                            }
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
//        System.out.println(solution("HaEaLaLaObWORLDb"));
        System.out.println(solution("SpIpGpOpNpGJqOqA"));
        System.out.println(solution("AxAxAxAoBoBoB"));
    }
}
