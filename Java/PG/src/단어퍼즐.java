public class 단어퍼즐 {
    static String[] base;
    static int answer = Integer.MAX_VALUE;
    public static void find(String now, int count, String target){
        if(now.equals(target)){
            answer = Math.min(count, answer);
            return;
        }
        if(now.length() > target.length()){
            return;
        }
        for(int i = 0 ; i < base.length; i++){
            find(now+base[i], count+1, target);
        }
    }
    public static int solution(String[] strs, String t){
        base = new String[strs.length];
        for(int i = 0 ; i < strs.length; i++){
            base[i] = strs[i];
        }
        for(int i = 0 ; i < strs.length; i++){
            find(base[i],1, t);
        }
        if(answer == Integer.MAX_VALUE){
            return -1;
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        System.out.println(solution(new String[] {"ba","na","n","a"},"banana"));
    }
}
