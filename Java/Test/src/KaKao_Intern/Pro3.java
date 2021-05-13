package KaKao_Intern;

import java.util.*;

public class Pro3 {
    static class Pair{
        int idx, value;             //idx : 있던 위치, value : 기존 값

        Pair(int a, int b){
            this.idx = a;
            this.value = b;
        }
    }
    public static int [] find(int  target, int k, String [] commands){
        Stack<Pair> removed = new Stack<Pair>();
        Queue<Pair> base = new LinkedList<Pair>();
        for(int i  = 0 ; i < target; i++){
            base.add(new Pair(i, i));
        }
        int count = 0;
        for(String command : commands){
            count += 1;
            String [] input = command.split(" ");
            if(input[0].equals("U")){
                k -= Integer.parseInt(input[1]);
                if(k < 0){
                    k = 0;
                }
            }else if(input[0].equals("D")){
                k += Integer.parseInt(input[1]);
                if(k >= target){
                    k = target - 1;
                }
            }else if(input[0].equals("C")){
                int n = base.size();
                for(int i = 0 ; i < k; i++){
                    Pair now = base.poll();
                    base.add(now);
                }
                removed.add(base.poll());
                for(int i = 0 ;i < n - k-1; i++){
                    Pair remove = base.poll();
                    base.add(new Pair(remove.idx+1, remove.value));
                }
            }else{
                Pair remove = removed.pop();
                if(remove.idx >= base.size()){
                    base.add(new Pair(base.size()+1, remove.value));
                }else{
                    int n = base.size();
                    for(int i = 0 ; i < remove.idx; i++){
                        base.add(base.poll());
                    }
                    base.add(remove);
                    for(int i = remove.idx; i < n ; i++){
                        Pair item = base.poll();
                        base.add(new Pair(item.idx+1, item.value));
                    }
                }
            }
        }
        int [] answer = new int[target];
        for(Pair remove : removed){
            answer[remove.value] = 1;
        }

        return answer;
    }
    public static String solution(int n, int k, String [] commands){
        StringBuilder sb = new StringBuilder();
        int [] N = new int[n];
        for(int i = 0 ; i < n; i++){
            N[i] = i;
        }
        int [] comp = find(n, k, commands);
        for(int i = 0 ; i < n; i++){
            if(0 == comp[i]){
                sb.append("O");
            }else{
                sb.append("X");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
       //System.out.println(solution(8, 2, new String [] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
        System.out.println(solution(8,2,new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
    }
}
