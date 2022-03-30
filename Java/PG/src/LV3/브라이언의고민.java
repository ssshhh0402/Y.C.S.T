package LV3;

public class 브라이언의고민 {
    public static String solution(String sentence){
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        boolean flag = true;
        int n = sentence.length();
        while(idx < n && flag){
            char now = sentence.charAt(idx);
            if(Character.isUpperCase(now)){
                idx += 1;
                sb.append(now);
            }else{
                if(sb.length() == 0){
                    while(idx < n){
                        char target = sentence.charAt(idx);
                        if(Character.isUpperCase(target)){
                            sb.append(target);
                        }else{
                            if(now == target){
                                answer.append(sb.toString());
                                if(idx != n-1){
                                    answer.append(" ");
                                }
                                sb = new StringBuilder();
                            }else{
                                flag = false;
                            }
                            break;
                        }
                        idx += 1;
                    }
                }else{
                    while(idx < n){
                        char target = sentence.charAt(idx);
                        if(Character.isUpperCase(target)){
                            answer.append(sb.toString());
                            if(idx != n-1){
                                answer.append(" ");
                            }
                            sb = new StringBuilder();
                            break;
                        }else{
                            if(target != now){
                                answer.append(sb.toString());
                                if(idx != n-1){
                                    answer.append(" ");
                                }
                                sb = new StringBuilder();
                                break;
                            }
                            sb.append(sentence.charAt(idx+1));
                        }
                        idx += 2;
                    }
                }
            }
        }
        if(sb.length() != 0){
            answer.append(sb.toString());
        }
        if(!flag || answer.length() == 0 ){
            return "invalid";
        }else{
            return answer.toString();
        }
    }
    public static void main(String[] args){
        String sentence = "AxAxAxAoBoBoB";
//        sentence = "SpIpGpOpNpGJqOqA";

        System.out.println(solution(sentence));
    }
}
