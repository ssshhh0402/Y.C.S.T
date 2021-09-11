package LineLate;

public class Pro5 {
    public static boolean isPossible(int count, String now_one, String now_two, int target, String nickOne, String nickTwo){
        if(count > 2){
            return false;
        }
        if(target == nickOne.length() || target == nickTwo.length()){
            int one = Math.abs(nickOne.length() - now_one.length());
            int two = Math.abs(nickTwo.length() - now_two.length());
            if(count + one + two > 2){
                return false;
            }else{
                return true;
            }
        }
        for(int idx = target; idx < Math.min(nickOne.length(), nickTwo.length()); idx++){
            if(idx < nickOne.length() && idx < nickTwo.length() && nickOne.charAt(idx) != nickTwo.charAt(idx)){
                boolean isPosOne = isPossible(count+1, now_one + nickOne.charAt(idx), now_two, idx, nickOne, nickTwo);
                boolean isPosTwo = isPossible(count+1, now_one, now_two + nickOne.charAt(idx), idx,nickOne, nickTwo);
                if(!isPosOne && !isPosTwo){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean nickCheck(String nickOne, String nickTwo){
        String[] temps = nickOne.split("");
        String[] tempsTwo = nickTwo.split("");
        boolean flag = false;
        int idx = 0;
        for(int i = 0 ; i < Math.min(temps.length, tempsTwo.length); i++){
            if(i < temps.length && i < tempsTwo.length && !temps[i].equals(tempsTwo[i])){
                idx = i;
                flag= true;
                break;
            }
        }
        if(!flag){
            return true;
        }else{
            boolean isPosOne, isPosTwo;
            if(idx == 0){
                isPosOne = isPossible(1, nickOne.substring(0,idx), "", idx+1, nickOne, nickTwo);
                isPosTwo = isPossible(1, "", nickTwo.substring(0,idx), idx+1, nickOne, nickTwo);
            }else{
                isPosOne = isPossible(1, nickOne.substring(0,idx), nickTwo.substring(0,idx-1), idx+1, nickOne, nickTwo);
                isPosTwo = isPossible(1, nickOne.substring(0,idx-1), nickTwo.substring(0,idx), idx+1, nickOne, nickTwo);
            }

            if(isPosOne || isPosTwo){
                return true;
            }
        }
        return false;

    }
    public static boolean emailCheck(String emailOne, String emailTwo){
        String [] split_one = emailOne.split("@");
        String [] split_two = emailTwo.split("@");
        if(split_one[0].equals(split_two[0])){
            return true;
        }else if(emailTwo.length() - emailOne.length() <= 1){
                return true;
        }else{
            for(int i = 0 ; i < Math.min(emailOne.length(), emailTwo.length()); i++){
                if(emailOne.charAt(i) != emailTwo.charAt(i)){
                    String one = emailOne.substring(0, i-1) + emailOne.substring(i+1);
                    if(one.equals(emailTwo)){
                        return true;
                    }else{
                        String two = emailTwo.substring(0, i-1) + emailTwo.substring(i+1);
                        if(two.equals(emailOne)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static int solution(String [] nicks, String [] emails){
        int answer = nicks.length;
        boolean [] check = new boolean[nicks.length];
        for(int x = 0; x < nicks.length; x++){
            for(int y  = x+1 ; y < nicks.length; y++){
                if(!check[x] && !check[y]){
                    if(nickCheck(nicks[x], nicks[y]) && emailCheck(emails[x],emails[y])){
                        check[x] = true;
                        check[y] = true;
                        answer -= 2;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String [] nicks = {"imhero111", "moneyman", "hero111", "imher1111", "hro111", "mmoneyman", "moneymannnn"};
        String [] emails = {"superman5@abcd.com", "batman432@korea.co.kr", "superman@abcd.com", "supertman5@abcd.com", "superman@erty.net", "batman42@korea.co.kr", "batman432@usa.com"};
        System.out.println(solution(nicks, emails));
    }
}
