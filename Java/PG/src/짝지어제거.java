import java.util.Stack;

public class 짝지어제거 {
    public static int solution(String s){
        Stack<String> q = new Stack<>();
        String [] base = s.split("");
        for(String now : base){
            if (q.isEmpty()){
                q.add(now);
            }else{
                String a = q.pop();
                if (!now.equals(a)){
                    q.add(a);
                    q.add(now);
                }
            }
        }
        if(q.size() == 0){
            return 1;
        }else{
            return 0;
        }
    }


    public static void main(String[] args){
        System.out.println(solution("baabaa"));
        System.out.println(solution("abba"));
    }
}
