import java.util.ArrayList;
import java.util.Arrays;

public class 괄호변환 {
    public static ArrayList<String[]> div(String[] items){
        ArrayList<String[]> temps = new ArrayList<String[]>();
        int left = 0;
        int right = 0;
        for(int i = 0 ; i < items.length;i ++){
            if(items[i].equals("(")){
                left += 1;
            }else{
                right += 1;
            }
            if(left == right){
                temps.add(Arrays.copyOfRange(items,0,i+1));
                temps.add(Arrays.copyOfRange(items, i+1, items.length));
                break;
            }
        }
        return temps;
    }
    public static boolean ordered(String[] items){
        int count = 0;
        for(String item : items){
            if(item.equals("(")){
                count += 1;
            }else{
                count -= 1;
            }
            if(count < 0){
                return false;
            }
        }
        return count == 0;
    }
    public static String[] rev(String[] items){
        int n = items.length;
        String[] temps = new String[n - 2];
        for(int i = 1; i < n - 1; i++){
            String target = items[i];
            if(target.equals("(")){
                temps[i-1] = ")";
            }else{
                temps[i-1] = "(";
            }
        }
        return temps;
    }
    public static String makeString(String[] items){
        StringBuilder sb = new StringBuilder();
        for(String item : items){
            sb.append(item);
        }
        return sb.toString();
    }
    public static String solution(String p){
        StringBuilder sb = new StringBuilder();
        String [] items = p.split("");
        String [] u, v;
        if(p.length() == 0){
            return sb.toString();
        }else{
            while(items.length != 0){
                ArrayList<String[]> temps = div(items);
                u = temps.get(0);
                v = temps.get(1);
                items = v;
                if(ordered(u)){
                    for(String item : u){
                        sb.append(item);
                    }
                }else{
                    sb.append("(");
                    sb.append(solution(makeString(v)));
                    sb.append(")");
                    String [] reversed = rev(u);
                    for(String item : reversed){
                        sb.append(item);
                    }
                    break;
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        //System.out.println(solution("(()())()"));
        System.out.println(solution("()))((()"));
    }
}
