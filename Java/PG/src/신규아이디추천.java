public class 신규아이디추천 {
    static StringBuilder sb;
    public static String step2(String target){
        sb = new StringBuilder();
        for(int i = 0; i < target.length(); i++){
            char now = target.charAt(i);
            if(now >= 'a' && now <= 'z'){
                sb.append(now);
            } else if(now == '_' || now == ('-') || now == ('.') || Character.isDigit(now)){
                sb.append(now);
            }
        }
        return sb.toString();
    }
    public static String solution(String new_id){
        new_id = new_id.toLowerCase();
        new_id = step2(new_id);
        while(new_id.contains("..")){
            new_id = new_id.replace("..", ".");
        }
        while(new_id.length() != 0){
            if (new_id.startsWith(".")){
                new_id = new_id.substring(1);
                continue;
            }
            if(new_id.charAt(new_id.length()-1) == '.'){
                new_id = new_id.substring(0,new_id.length()-1);
                continue;
            }
            break;
        }
        if(new_id.length() == 0){
            new_id = "a";
        }else if(new_id.length() >= 16){
            new_id = new_id.substring(0,15);
        }
        while(new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0,new_id.length()-1);
        }
        while(new_id.length() < 3){
            new_id += new_id.charAt(new_id.length()-1);
        }

        return new_id;
    }
    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }
}

