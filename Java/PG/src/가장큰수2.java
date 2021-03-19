import java.util.Arrays;

public class 가장큰수2 {
    static class Item implements Comparable<Item>{
        String value;

        Item(int number){
            this.value = String.valueOf(number);
        }
        public int compareTo(Item i){
            return (i.value + this.value).compareTo(this.value + i.value);
        }
    }
    public static String solution(int[] numbers){
        String answer = "";
        Item [] items = new Item [numbers.length];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            items[i] = new Item(numbers[i]);
        }
        Arrays.sort(items);
        for(Item item : items){
            sb.append(item.value);
        }
        answer = sb.toString();
        if(answer.startsWith("0")){
            return "0";
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        System.out.println(solution(new int [] {6,10,2}));
        System.out.println(solution(new int [] {0,0,0,0}));

    }
}
