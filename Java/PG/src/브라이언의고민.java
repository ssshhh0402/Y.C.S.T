import java.util.LinkedList;
import java.util.Queue;

public class 브라이언의고민 {
    public static String solution(String sentence) {
        StringBuilder answer = new StringBuilder();
        StringBuilder temps = new StringBuilder();
        int count = 0;
        int flag = 0;
        for(int i = 0 ; i < sentence.length(); i++){
            char now = sentence.charAt(i);
            if(Character.isUpperCase(now)){
                count += 1;
                temps.append(now);
            }else{
                if((i+2) < sentence.length() && sentence.charAt(i+2) == now){
                    int j = i+2;
                    while(j < sentence.length()){
                        temps.append(sentence.charAt(j-1));
                        count += 1;
                        if((j+2) < sentence.length() && sentence.charAt(j+2) == now){
                            j += 2;
                        }else{
                            temps.append(sentence.charAt(j+1));
                            answer.append(temps.toString()).append(" ");
                            flag += 1;
                            temps = new StringBuilder();
                            i = j+1;
                            break;
                        }
                    }
                }else{
                    for(int j = i+1; j < sentence.length(); j++){
                        char target = sentence.charAt(j);
                        if(Character.isLowerCase(target)){
                            if(target == now){
                                answer.append(temps.toString()).append(" ");
                                flag += 1;
                                temps = new StringBuilder();
                                i = j;
                                break;
                            }else{
                                return "invalid";
                            }
                        }else{
                            temps.append(target);
                            count += 1;
                        }
                    }
                }
            }
        }
        int kkk = sentence.length();
        flag -= 1;
        answer.deleteCharAt(answer.length()-1);
        if(answer.length() + count - flag == sentence.length()){
            return answer.toString();
        }else{
            return "invalid";
        }
    }
    public static void main(String[] args){
        System.out.println(solution("HaEaLaLaObWORLDb"));
        System.out.println(solution("SpIpGpOpNpGJqOqA"));
        System.out.println(solution("AxAxAxAoBoBoB"));
    }
}
