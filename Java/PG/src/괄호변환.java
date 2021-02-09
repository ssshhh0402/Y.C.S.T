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
                temps.add(Arrays.copyOfRange(items, i+1, items.length - 1));
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
        String[] temps = new String[items.length - 2];
        return temps;
    }
    public static String solution(String p){
        StringBuilder sb = new StringBuilder();
        String [] items = p.split("");
        String [] u, v;
        if(items.length == 0){
            return sb.toString();
        }else{
            ArrayList<String[]> temps = div(items);
            u = temps.get(0);
            v = temps.get(1);
            if(ordered(u)){
                String[] V= solution(v.toString()).split("");
                sb.append(u);
                sb.append(V);
            }else{
                sb.append("(");
                String[] U = solution(u.toString()).split("");
                for(String item : U){
                    sb.append(item);
                }
                sb.append(")");
                String[] V = rev(v);
                }

            }

        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(solution("(()())()"));
    }
}
