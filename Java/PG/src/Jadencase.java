public class Jadencase {
    public static String solution(String s){
        String[] S = s.split("");
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(String item : S){
            if(item.equals(" ")){
                flag = false;
                sb.append(item);
            }else{
                if(!flag){
                    flag = true;
                    sb.append(item.toUpperCase());
                }else{
                    sb.append(item.toLowerCase());
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(solution("3people unFollowed me"));
        String now = solution("A");
        System.out.println(now.length());
        System.out.println(now);
    }
}
