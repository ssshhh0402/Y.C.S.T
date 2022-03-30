import java.util.*;
public class ArrayConversion {
    public static class Item implements Comparable<Item>{
        int idx, value;

        Item(int a, int b){
            this.idx = a;
            this.value = b;
        }
        @Override
        public int compareTo(Item i){
            if(this.value == i.value){
                return this.idx - i.idx;
            }else{
                return this.value - i.value;
            }
        }
    }
    public static int solution(int[] A) {
        int n = A.length;
        int answer = 0;
        ArrayList<Item> al = new ArrayList<Item>();
        for(int i = 0; i < A.length; i++){
            al.add(new Item(i, A[i]));
        }
        Collections.sort(al);
        for(int i = 0; i < n; i++){
            if(al.get(i).value >= 0) {
                int value = al.get(i).value, idx = al.get(i).idx;
                for (int j = 0; j < n; j++) {
                    Item target = al.get(j);
                    if(target.value < value && target.idx > idx){
                        answer += 1;
                    }else{
                        break;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] A = new int []   {-1, 6, 3, 4, 7, 4};
        System.out.println(solution(A));
    }
}
