package LV3;

public class 브라이언의고민2 {
    public static String[] getInform(int idx, String sentence){
        String [] result = new String[2];
        StringBuilder sb = new StringBuilder();
        char target = sentence.charAt(idx);
        for(int i = idx; i < sentence.length(); i+=2){
            if(sentence.charAt(i) == target){
                sb.append(i-1);
            }else{
                sb.append(i-1);
                result[0] = sb.toString();
                result[1] = String.valueOf(i);
            }
        }
        return result;
    }
    public static String solution(String sentence){
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int idx = 0, n = sentence.length();
        for(int i = 0; i < n; i++){
            char now = sentence.charAt(i), next = sentence.charAt(i+1);
            if(Character.isUpperCase(now) && Character.isLowerCase(next)){
                String [] result = getInform(i, sentence);
                sb.append(result[0]);
                i = Integer.valueOf(result[1]);
            }else if(Character.isLowerCase(now) && Character.isUpperCase(next)){

            }
        }
        return answer.toString();
    }
    public static void main(String[] args){
        String sentence = "HaEaLaLaObWORLDb";
        System.out.println(solution(sentence));
    }
}
