
public class Review {
    static int answer,n;
    static boolean[] used;
    public static boolean isPossible(String one, String two){
        int count = 0;
        for(int i = 0; i < one.length(); i++){
            if(one.charAt(i) != two.charAt(i)){
                count += 1;
                if(count >= 2){
                    return false;
                }
            }
        }
        return true;
    }
    public static void find(String now, String target, String[] words, int count){
        if (now.equals(target)){
            answer = Math.min(answer, count);
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(!used[i] && isPossible(now, words[i])){
                used[i] = true;
                find(words[i], target, words, count+1);
                used[i] = false;
            }
        }
    }
    public static int solution(String begin, String target, String [] words){
        answer = Integer.MAX_VALUE;
        n = words.length;
        used = new boolean[n];
        find(begin, target, words,0);
        if(answer == Integer.MAX_VALUE){
            return 0;
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        String begin = "hit";
        String target = "cog";
        String [] words = new String [] {"hot","dot","dog","lot","log","cog"};
        System.out.println(solution(begin, target, words));
        words = new String [] {"hot","dot","dog","lot","log"};
        System.out.println(solution(begin, target, words));
    }
}
