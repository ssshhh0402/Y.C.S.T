import java.util.ArrayDeque;
import java.util.Deque;

public class 단어변환 {
    public static boolean isPossible(String one, String two){
        boolean flag = false;
        for(int i = 0 ; i < one.length(); i++){
            if(one.charAt(i) != two.charAt(i)){
                if(flag){
                    return false;
                }else{
                    flag = true;
                }
            }
        }
        return true;
    }
    public static int solution(String begin, String target, String[] words){
        int answer = 0;
        Deque<String> dq = new ArrayDeque<String>();
        boolean flag = false;

        for(int i= 0 ; i < words.length; i++){
            if(target.equals(words[i])){
                flag = true;
                break;
            }
        }
        if(flag){
            dq.add(begin);
            while(true){
                int n = dq.size();
                for(int i = 0 ; i < n; i++){
                    String now = dq.pollFirst();
                    if(now.equals(target)){
                        dq.clear();
                        break;
                    }
                    for(int j = 0 ; j < words.length; j++){
                        if(isPossible(now, words[j])){
                            dq.add(words[j]);
                        }
                    }
                }
                if(dq.isEmpty()){
                    break;
                }else{
                    answer += 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution("hit","cog", new String[] {"hot","dot","dog","lot","log","cog"}));
        System.out.println(solution("hit","cog",new String[] {"hot","dot","dog","lot","log"}));
    }
}
