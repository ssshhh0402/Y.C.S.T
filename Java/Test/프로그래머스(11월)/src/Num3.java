import java.util.ArrayList;
import java.util.List;

public class Num3 {
    public static boolean check1(ArrayList<List<Integer>> target){
        int count = 0;
        for(int item = 0; item < 2; item++){
            boolean flag = true;
            int tar = target.get(0).get(item);
            for(int idx = 1; idx < target.size(); idx++){
                List<Integer> now = target.get(idx);
                if(!now.contains((int)tar)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                count += 1;
            }
        }
        if (count >= 1){
            return true;
        }else{
            return false;
        }
    }
    public static boolean check2(ArrayList<List<Integer>> target){
        boolean flag = true;
        for(List<Integer> now : target){
            if (now.get(0) == now.get(1)){
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static boolean find(List<Integer> subList){
        ArrayList<List<Integer>> subs = new ArrayList<>();
        for(int idx = 0; idx < subList.size(); idx += 2){
            subs.add(subList.subList(idx, idx+2));
        }
        if (check1(subs) && check2(subs)){
            return true;
        }else{
            return false;
        }

    }
    public static int solution(int[] a){
        if (a.length == 1){
            return 0;
        }
        List<Integer> b = new ArrayList<Integer>();
        for(int item : a){
            b.add(item);
        }
        int n = a.length;
        int size = a.length;
        if (size % 2 != 0){
            size -= 1;
        }
        while(size >= 2){
            boolean flag = false;
            for(int idx = 0; idx < n-size+1;idx++){
                List<Integer> subs = b.subList(idx, idx+size);
                if(find(subs)){
                    flag = true;
                    break;
                }
            }
            if (flag) {
                return size;
            }else{
                size -= 2;
            }
        }
        return -1;
    }

    public static void main(String[] args){
//        System.out.println(solution( new int [] {0}));
//        System.out.println(solution(new int [] {5,2,3,3,5,3}));
        System.out.println(solution(new int [] {0,3,3,0,7,2,0,2,2,0}));

    }
}
