import java.util.Arrays;

public class Hindex {
    public static int find(int[] citations){
        int answer = 0;
        Arrays.sort(citations);
        for(int i = 0 ; i < citations.length; i++){
            if(citations[i] >= citations.length - i){
                return citations[i];
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(find(new int[]{3,0,6,1,5}));
    }
}
